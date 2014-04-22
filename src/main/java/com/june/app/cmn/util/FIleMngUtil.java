package com.june.app.cmn.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.june.app.board.web.BoardController;
import com.june.app.cmn.model.FileDetail;

public class FIleMngUtil {
	
	
	private static final Logger logger = LoggerFactory.getLogger(FIleMngUtil.class);
	
	public static FileDetail writeFile(MultipartHttpServletRequest request, String filePath) {
		String streFileNm = "";
		FileDetail fileDetail = new FileDetail();
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = request.getFile(itr.next());
		try {
			int length = mpf.getBytes().length;
			byte[] bytes = mpf.getBytes();
			String type = mpf.getContentType();
			String orignlFileNm = mpf.getOriginalFilename();
			double kilobytes = (length / 1024);
			
			/**날짜별로 폴더생성*/
			Calendar cal = Calendar.getInstance();
		    String dateString = "/"+String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH))+ "/";
		    String fullPath = filePath + dateString;	
			File targetPath = new File(fullPath);
			if (!targetPath.exists()) {
				if (!targetPath.mkdirs()) {
					throw new IOException("not create direcotry: "
							+ targetPath.getAbsolutePath());
				}
			}
			/**랜덤파일명 생성*/
			streFileNm = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			
			File targetFile = new File(targetPath.getAbsolutePath(), streFileNm);
			
			if (!targetFile.exists()) {
				// targetFile.createNewFile();
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
						fullPath + streFileNm));

			}
			logger.debug("===============] setFileExtsnsetFileExtsn [================{}",type);
			fileDetail.setFileStreCours(dateString);
			fileDetail.setStreFileNm(streFileNm);
			fileDetail.setOrignlFileNm(orignlFileNm);
			fileDetail.setFileExtsn(type);
			fileDetail.setFileSize(kilobytes);
			fileDetail.setFileSn(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileDetail;
	}
	
	
	public static FileDetail writeFile(MultipartFile file, String filePath) {
		String streFileNm = "";
		FileDetail fileDetail = new FileDetail();
		//Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = file;
		try {
			int length = mpf.getBytes().length;
			byte[] bytes = mpf.getBytes();
			String type = mpf.getContentType();
			String orignlFileNm = mpf.getOriginalFilename();
			double kilobytes = (length / 1024);
			
			/**날짜별로 폴더생성*/
			Calendar cal = Calendar.getInstance();
		    String dateString = "/"+String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH))+ "/";
		    String fullPath = filePath + dateString;	
			File targetPath = new File(fullPath);
			if (!targetPath.exists()) {
				if (!targetPath.mkdirs()) {
					throw new IOException("not create direcotry: "
							+ targetPath.getAbsolutePath());
				}
			}
			/**랜덤파일명 생성*/
			streFileNm = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
			
			File targetFile = new File(targetPath.getAbsolutePath(), streFileNm);
			
			if (!targetFile.exists()) {
				// targetFile.createNewFile();
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
						fullPath + streFileNm));

			}
			logger.debug("===============] setFileExtsnsetFileExtsn [================{}",type);
			fileDetail.setFileStreCours(dateString);
			fileDetail.setStreFileNm(streFileNm);
			fileDetail.setOrignlFileNm(orignlFileNm);
			fileDetail.setFileExtsn(type);
			fileDetail.setFileSize(kilobytes);
			fileDetail.setFileSn(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileDetail;
	}
	
	public static FileDetail writeFileWithOraginalName(MultipartHttpServletRequest request, String filePath) {
		String streFileNm = "";
		FileDetail fileDetail = new FileDetail();
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = request.getFile(itr.next());
		try {
			int length = mpf.getBytes().length;
			byte[] bytes = mpf.getBytes();
			String type = mpf.getContentType();
			String orignlFileNm = mpf.getOriginalFilename();
			double kilobytes = (length / 1024);
			
			/**날짜별로 폴더생성*/
			Calendar cal = Calendar.getInstance();
		    String dateString = "/"+String.format("%04d-%02d-%02d", cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH))+ "/";
		    String fullPath = filePath + dateString;	
			File targetPath = new File(fullPath);
			if (!targetPath.exists()) {
				if (!targetPath.mkdirs()) {
					throw new IOException("not create direcotry: "
							+ targetPath.getAbsolutePath());
				}
			}
			/**랜덤파일명 생성*/
			
			File targetFile = new File(targetPath.getAbsolutePath(), orignlFileNm);
			
			if (!targetFile.exists()) {
				// targetFile.createNewFile();
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(
						fullPath + streFileNm));

			}
			
			fileDetail.setFileStreCours(dateString);
			fileDetail.setStreFileNm(streFileNm);
			fileDetail.setOrignlFileNm(orignlFileNm);
			fileDetail.setFileExtsn(type);
			fileDetail.setFileSize(kilobytes);
			fileDetail.setFileSn(0);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileDetail;
	}
}
