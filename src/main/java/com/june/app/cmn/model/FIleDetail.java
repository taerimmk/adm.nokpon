package com.june.app.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FILE_DETAIL")
public class FIleDetail {
	
	@Id                                                
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATCH_FILE_ID")
	private String atchFileId;

	@Column(name = "FILE_SN")
	private String fileSn;
	
	@Column(name = "FILE_STRE_COURS")
	private String fileStreCours;
	
	@Column(name = "STRE_FILE_NM")
	private String streFile_nm;
	
	@Column(name = "ORIGNL_FILE_NM")
	private String orignlFile_nm;
	
	@Column(name = "FILE_EXTSN")
	private String fileExtsn;
	
	@Column(name = "FILE_CN")
	private String fileCn;
	
	@Column(name = "FILE_SIZE")
	private String fileSize;

	public String getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	public String getFileSn() {
		return fileSn;
	}

	public void setFileSn(String fileSn) {
		this.fileSn = fileSn;
	}

	public String getFileStreCours() {
		return fileStreCours;
	}

	public void setFileStreCours(String fileStreCours) {
		this.fileStreCours = fileStreCours;
	}

	public String getStreFile_nm() {
		return streFile_nm;
	}

	public void setStreFile_nm(String streFile_nm) {
		this.streFile_nm = streFile_nm;
	}

	public String getOrignlFile_nm() {
		return orignlFile_nm;
	}

	public void setOrignlFile_nm(String orignlFile_nm) {
		this.orignlFile_nm = orignlFile_nm;
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

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}
	
	

}