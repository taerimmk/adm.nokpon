package com.june.app.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILE_DETAIL")
public class FileDetail {
	
	@Id
	@Column(name = "ATCH_FILE_ID")
	private String atchFileId;
	
	@Column(name = "FILE_SN")
	private int fileSn;
	
	@Column(name = "FILE_STRE_COURS")
	private String fileStreCours;
	
	@Column(name = "STRE_FILE_NM")
	private String streFileNm;
	
	@Column(name = "ORIGNL_FILE_NM")
	private String orignlFileNm;
	
	@Column(name = "FILE_EXTSN")
	private String fileExtsn;
	
	@Column(name = "FILE_CN")
	private String fileCn;
	
	@Column(name = "FILE_SIZE")
	private double fileSize;

	public String getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	public int getFileSn() {
		return fileSn;
	}

	public void setFileSn(int fileSn) {
		this.fileSn = fileSn;
	}

	public String getFileStreCours() {
		return fileStreCours;
	}

	public void setFileStreCours(String fileStreCours) {
		this.fileStreCours = fileStreCours;
	}

	

	public String getStreFileNm() {
		return streFileNm;
	}

	public void setStreFileNm(String streFileNm) {
		this.streFileNm = streFileNm;
	}

	public String getOrignlFileNm() {
		return orignlFileNm;
	}

	public void setOrignlFileNm(String orignlFileNm) {
		this.orignlFileNm = orignlFileNm;
	}

	public String getFileExtsn() {
		return fileExtsn;
	}

	public void setFileExtsn(String fileExtsn) {
		this.fileExtsn = fileExtsn;
	}

	public String getFileCn() {
		return fileCn;
	}

	public void setFileCn(String fileCn) {
		this.fileCn = fileCn;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	
	

}