package com.june.app.cmn.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "FILE_LIST")
public class FIleList {
	
	/*@Id                                                
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ATCH_FILE_ID")*/
	@Id 
    @GeneratedValue(generator="system-uuid") 
    @GenericGenerator(name="system-uuid", strategy = "uuid") 
	@Column(name = "ATCH_FILE_ID")
	private String atchFileId;

	@Column(name = "CREAT_DT")
	private Date creatDt;

	@Column(name = "USE_YN")
	private String useYn;

	public String getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}
	
	public Date getCreatDt() {
		return creatDt;
	}

	public void setCreatDt(Date creatDt) {
		this.creatDt = creatDt;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	@Override
	public String toString() {
		return "FIleList [atchFileId=" + atchFileId + ", creatDt=" + creatDt
				+ ", useYn=" + useYn + "]";
	}
	

}