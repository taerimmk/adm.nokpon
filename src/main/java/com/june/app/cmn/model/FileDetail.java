package com.june.app.cmn.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.june.app.board.model.Board;

@Entity
@Table(name = "FILE_DETAIL")
public class FileDetail {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
    protected Integer seq;
	
	
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

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

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

	@Override
	public String toString() {
		return "FileDetail [seq=" + seq + ", atchFileId=" + atchFileId
				+ ", fileSn=" + fileSn + ", fileStreCours=" + fileStreCours
				+ ", streFileNm=" + streFileNm + ", orignlFileNm="
				+ orignlFileNm + ", fileExtsn=" + fileExtsn + ", fileCn="
				+ fileCn + ", fileSize=" + fileSize + "]";
	}
	

	

}