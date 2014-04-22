package com.june.app.cmn.web;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;
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
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.june.app.cmn.model.FileDetail;
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

	// @Autowired FileService fileService;
	// @Autowired Properties propUtil;
	@Value("#{propUtil['file.Path']}")
	private String filePath;

	/**
	 * 이미지 업로드 Single insert DB
	 */
	@RequestMapping(value = "/image/upload/db", method = RequestMethod.POST)
	public String uploadImageDB(MultipartHttpServletRequest request, Model model) {

		FileDetail fileDetail = fileService.fileSaveDB(request);
		
		String setUrl = "<c:url value='/getImage/"+fileDetail.getAtchFileId()+"/"+fileDetail.getFileSn()+"'/>";
		model.addAttribute("atchFileId", fileDetail.getAtchFileId());
		model.addAttribute("fileSn", fileDetail.getFileSn());
		model.addAttribute("setUrl", setUrl);
		
		return String.valueOf(Calendar.getInstance().getTimeInMillis());

	}
	
	/**
	 * 이미지 업로드 Single without DB
	 */
	@RequestMapping(value = "/image/upload", method = RequestMethod.POST)
	public String uploadImage(MultipartHttpServletRequest request, Model model) {

		FileDetail fileDetail = fileService.fileSave(request, filePath);
		model.addAttribute("orignlFileNm", fileDetail.getOrignlFileNm());
		model.addAttribute("fileStreCours", fileDetail.getFileStreCours());
		
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

	@RequestMapping(value = "/fileDown/{atchFileId}/{fileSn}")
	public void cvplFileDownload(
			@PathVariable String atchFileId,
			@PathVariable int fileSn, 
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {


		FileDetail filedetail = new FileDetail();
		if (!StringUtils.isEmpty(filedetail)){
			filedetail.setAtchFileId(atchFileId);
			filedetail.setFileSn(fileSn);
			filedetail = fileService.fileSingle(filedetail);
		}
		String fullPath = filePath + filedetail.getFileStreCours();
	    File uFile = new File(fullPath, filedetail.getStreFileNm());
	    int fSize = (int)uFile.length();

	    if (fSize > 0) {
		String mimetype = "application/x-msdownload";

		//response.setBufferSize(fSize);	// OutOfMemeory 발생
		response.setContentType(mimetype);
		//response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode(fvo.getOrignlFileNm(), "utf-8") + "\"");
		setDisposition(filedetail.getOrignlFileNm(), request, response);
		response.setContentLength(fSize);

		/*
		 * FileCopyUtils.copy(in, response.getOutputStream());
		 * in.close(); 
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
		    //ex.printStackTrace();
		    // 다음 Exception 무시 처리
		    // Connection reset by peer: socket write error
		    logger.debug("IGNORED: " + ex.getMessage());
		} finally {
		    if (in != null) {
			try {
			    in.close();
			} catch (Exception ignore) {
			    // no-op
				logger.debug("IGNORED: " + ignore.getMessage());
			}
		    }
		    if (out != null) {
			try {
			    out.close();
			} catch (Exception ignore) {
			    // no-op
				logger.debug("IGNORED: " + ignore.getMessage());
			}
		    }
		}

	    } else {
		response.setContentType("application/x-msdownload");

		PrintWriter printwriter = response.getWriter();
		printwriter.println("<html>");
		printwriter.println("<br><br><br><h2>Could not get file name:<br>" + filedetail.getOrignlFileNm() + "</h2>");
		printwriter.println("<br><br><br><center><h3><a href='javascript: history.go(-1)'>Back</a></h3></center>");
		printwriter.println("<br><br><br>&copy; webAccess");
		printwriter.println("</html>");
		printwriter.flush();
		printwriter.close();
	    }
	}

	@RequestMapping("/getImageDB/{atchFileId}/{fileSn}")
	public void getImageDB(ModelMap model, 
			@PathVariable String atchFileId,
			@PathVariable int fileSn,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		FileDetail filedetail = new FileDetail();
		if (!StringUtils.isEmpty(filedetail)){
			filedetail.setAtchFileId(atchFileId);
			filedetail.setFileSn(fileSn);
			filedetail = fileService.fileSingle(filedetail);
		}
		String fileExtsn = filedetail.getFileExtsn();
		String fullPath = filePath + filedetail.getFileStreCours();
		File file = new File(fullPath, filedetail.getStreFileNm());
		FileInputStream fis = null;

		BufferedInputStream in = null;
		ByteArrayOutputStream bStream = null;
		
		try {
			fis = new FileInputStream(file);
			in = new BufferedInputStream(fis);
			bStream = new ByteArrayOutputStream();
			int imgByte;
			while ((imgByte = in.read()) != -1) {
				bStream.write(imgByte);
			}

			String type = "";
			if (!StringUtils.isEmpty(fileExtsn))
			{
				
				type = fileExtsn;
			} else {
				logger.debug("Image fileType is null.");
			}
			
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
	
	
	@RequestMapping("/getImage/{orignlFileNm}/{fileStreCours}")
	public void getImage(ModelMap model, 
			@PathVariable String atchFileId,
			@PathVariable int fileSn,
			HttpServletResponse response) throws Exception {
		
		FileDetail filedetail = new FileDetail();
		if (!StringUtils.isEmpty(filedetail)){
			filedetail.setAtchFileId(atchFileId);
			filedetail.setFileSn(fileSn);
			filedetail = fileService.fileSingle(filedetail);
		}
		String fileExtsn = filedetail.getFileExtsn();
		String fullPath = filePath + filedetail.getFileStreCours();
		File file = new File(fullPath, filedetail.getStreFileNm());
		FileInputStream fis = null;

		BufferedInputStream in = null;
		ByteArrayOutputStream bStream = null;

		try {
			fis = new FileInputStream(file);
			in = new BufferedInputStream(fis);
			bStream = new ByteArrayOutputStream();
			int imgByte;
			while ((imgByte = in.read()) != -1) {
				bStream.write(imgByte);
			}

			String type = "";
			if (!StringUtils.isEmpty(fileExtsn))
			{
				
				type = fileExtsn;
			} else {
				logger.debug("Image fileType is null.");
			}
			
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
}
