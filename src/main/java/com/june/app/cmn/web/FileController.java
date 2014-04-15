package com.june.app.cmn.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.june.app.cmn.model.FIleList;
import com.june.app.cmn.service.FileService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class FileController {

	private static final Logger logger = LoggerFactory
			.getLogger(FileController.class);
	
	private final FileService fileService;
	
	@Autowired
    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

	//@Autowired FileService fileService;
	//@Autowired Properties propUtil;
	@Value("#{propUtil['file.Path']}") private String filePath;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/image/upload", method = RequestMethod.POST)
	public String uploadLogo(MultipartHttpServletRequest request, Model model) {
		Iterator<String> itr = request.getFileNames();
		//String filePath = (String) propUtil.get("file.Path");

		MultipartFile mpf = request.getFile(itr.next());
		Date today = new Date();
		
		SimpleDateFormat sdformat  = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println("날짜: "+sdformat.format(today));
		FIleList fIleList = new FIleList();
		fIleList.setUseYn("Y");
		//fIleList.setCreatDt(today);
		fIleList = fileService.fileListSave(fIleList);
		logger.debug("=====] fIleList [========{}",fIleList.getAtchFileId());
		try {
			int length = mpf.getBytes().length;
			byte[] bytes = mpf.getBytes();
			String type = mpf.getContentType();
			String name = mpf.getOriginalFilename();
			
			File targetPath = new File(filePath + File.separator);
			if (!targetPath.exists()) {
				if (!targetPath.mkdirs()) {
					throw new IOException("not create direcotry: "
							+ targetPath.getAbsolutePath());
				}
			}

			File targetFile = new File(targetPath.getAbsolutePath(), name);
			if (!targetFile.exists()) {
				// targetFile.createNewFile();
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
						filePath + mpf.getOriginalFilename()));

			}


		} catch (IOException e) {
			e.printStackTrace();
		}
		model.addAttribute("getOriginalFilename", mpf.getOriginalFilename());

		return String.valueOf(Calendar.getInstance().getTimeInMillis());

	}

	/***************************************************
	 * URL: /rest/controller/get/{value} get(): get file as an attachment
	 * 
	 * @param response
	 *            : passed by the server
	 * @param value
	 *            : value from the URL
	 * @return void
	 ****************************************************/
	/*
	 * @RequestMapping(value = "/get/{value}", method = RequestMethod.GET)
	 * public void get(HttpServletResponse response,@PathVariable String value){
	 * FileMeta getFile = files.get(Integer.parseInt(value)); try {
	 * response.setContentType(getFile.getFileType());
	 * response.setHeader("Content-disposition",
	 * "attachment; filename=\""+getFile.getFileName()+"\"");
	 * FileCopyUtils.copy(getFile.getBytes(), response.getOutputStream());
	 * }catch (IOException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 */

	/*
	 * @RequestMapping(value = "/fileDown.do", method = RequestMethod.GET)
	 * public ModelAndView fileDown(@RequestParam("fileName") String fileName) {
	 * String fullPath = "d:/image/" + fileName ; File downloadFile = new
	 * File(fullPath); return new ModelAndView("download", "downloadFile",
	 * downloadFile); }
	 */

	@RequestMapping(value = "/fileDown/{fileName}")
	public void cvplFileDownload(Map<String, Object> commandMap,
			@PathVariable String fileName, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		String atchFileId = (String) commandMap.get("atchFileId");
		String fileSn = (String) commandMap.get("fileSn");
		// String fileName = request.getParameter("fileName");
		File uFile = new File(filePath, fileName);
		int fSize = (int) uFile.length();

		if (fSize > 0) {
			String mimetype = "application/x-msdownload";

			// response.setBufferSize(fSize); // OutOfMemeory 발생
			response.setContentType(mimetype);
			// response.setHeader("Content-Disposition",
			// "attachment; filename=\"" +
			// URLEncoder.encode(fvo.getOrignlFileNm(), "utf-8") + "\"");
			setDisposition(fileName, request, response);
			response.setContentLength(fSize);

			/*
			 * FileCopyUtils.copy(in, response.getOutputStream()); in.close();
			 * response.getOutputStream().flush();
			 * response.getOutputStream().close();
			 */
			BufferedInputStream in = null;
			BufferedOutputStream out = null;

			try {
				in = new BufferedInputStream(new FileInputStream(uFile));
				out = new BufferedOutputStream(response.getOutputStream());

				FileCopyUtils.copy(in, out);
				out.flush();
			} catch (Exception ex) {
				// ex.printStackTrace();
				// 다음 Exception 무시 처리
				// Connection reset by peer: socket write error
			} finally {
				if (in != null) {
					try {
						in.close();
					} catch (Exception ignore) {
						// no-op
					}
				}
				if (out != null) {
					try {
						out.close();
					} catch (Exception ignore) {
						// no-op
					}
				}
			}

		} else {
			response.setContentType("application/x-msdownload");

			PrintWriter printwriter = response.getWriter();
			printwriter.println("<html>");
			/*
			 * printwriter.println("<br><br><br><h2>Could not get file name:<br>"
			 * + fvo.getOrignlFileNm() + "</h2>");
			 */
			printwriter
					.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
			printwriter.println("<br><br><br>&copy; webAccess");
			printwriter.println("</html>");
			printwriter.flush();
			printwriter.close();
		}
	}

	/**
	 * 브라우저 구분 얻기.
	 * 
	 * @param request
	 * @return
	 */
	private String getBrowser(HttpServletRequest request) {
		String header = request.getHeader("User-Agent");
		if (header.indexOf("MSIE") > -1) {
			return "MSIE";
		} else if (header.indexOf("Chrome") > -1) {
			return "Chrome";
		} else if (header.indexOf("Opera") > -1) {
			return "Opera";
		}
		return "Firefox";
	}

	/**
	 * Disposition 지정하기.
	 * 
	 * @param filename
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	private void setDisposition(String filename, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		String browser = getBrowser(request);

		String dispositionPrefix = "attachment; filename=";
		String encodedFilename = null;

		if (browser.equals("MSIE")) {
			encodedFilename = URLEncoder.encode(filename, "UTF-8").replaceAll(
					"\\+", "%20");
		} else if (browser.equals("Firefox")) {
			encodedFilename = "\""
					+ new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Opera")) {
			encodedFilename = "\""
					+ new String(filename.getBytes("UTF-8"), "8859_1") + "\"";
		} else if (browser.equals("Chrome")) {
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < filename.length(); i++) {
				char c = filename.charAt(i);
				if (c > '~') {
					sb.append(URLEncoder.encode("" + c, "UTF-8"));
				} else {
					sb.append(c);
				}
			}
			encodedFilename = sb.toString();
		} else {
			// throw new RuntimeException("Not supported browser");
			throw new IOException("Not supported browser");
		}

		response.setHeader("Content-Disposition", dispositionPrefix
				+ encodedFilename);

		if ("Opera".equals(browser)) {
			response.setContentType("application/octet-stream;charset=UTF-8");
		}
	}

	@RequestMapping("/getImage/{filename:.+}")
	public void getImageInf(ModelMap model,
			@PathVariable String filename,
			HttpServletResponse response)
			throws Exception {


		File file = new File(filePath, filename);
		FileInputStream fis = null;

		BufferedInputStream in = null;
		ByteArrayOutputStream bStream = null;
		
		int extFileIndex = filename.lastIndexOf(".");
		String extFile =  filename.substring(extFileIndex);
		try {
			fis = new FileInputStream(file);
			in = new BufferedInputStream(fis);
			bStream = new ByteArrayOutputStream();
			int imgByte;
			while ((imgByte = in.read()) != -1) {
				bStream.write(imgByte);
			}
			
			String type = "";
			//if (fvo.getFileExtsn() != null && !"".equals(fvo.getFileExtsn())) {
				if ("jpg".equals(extFile.toLowerCase())) {
					type = "image/jpeg"; // TODO 정말 이런걸까?
				} else {
					type = "image/" + extFile.toLowerCase();
				}
				type = "image/" + extFile.toLowerCase();

			//} else {
				//log.debug("Image fileType is null.");
			//}
				
			response.setHeader("Content-Type", type);
			response.setContentLength(bStream.size());

			bStream.writeTo(response.getOutputStream());

			response.getOutputStream().flush();
			response.getOutputStream().close();

		} catch (Exception e) {
		} finally {
			if (bStream != null) {
				try {
					bStream.close();
				} catch (Exception est) {
				}
			}
			if (in != null) {
				try {
					in.close();
				} catch (Exception ei) {
				}
			}
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception efis) {
				}
			}
		}
	}
}
