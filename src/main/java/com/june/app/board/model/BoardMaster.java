/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.june.app.board.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.june.app.cmn.model.Pagination;

/**
 * Simple JavaBean domain object representing an person.
 * 
 * @author Ken Krebs
 */
@Entity
@Table(name = "BBS_MST")
public class BoardMaster{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BBS_ID")
	@NotNull
	private Integer bbsId;
	
    @Column(name = "BBS_NM")
    private String bbsNm;
	
    @Column(name = "BBS_TYPE_CODE")
    private String bbsTypeCode;
    @Column(name = "BBS_ATTR_CODE")
    private String bbsAttrCode;
    @Column(name = "REPLY_POSBL_YN")
    private String replyPosblYn;
    @Column(name = "FILE_ATCH_POSBL_YN")
    private String fileAtchPosblYn;
    @Column(name = "ATCH_POSBL_FILE_NUMBER")
    private Integer atchPosblFileNumber;
    @Column(name = "ATCH_POSBL_FILE_SIZE")
    private Integer atchPosblFileSize;
    @Column(name = "USE_YN")
    private String useYn;
    @Column(name = "TMPLAT_ID")
    private String tmplatId;
    @Column(name = "REG_DATE")
    private Date regDate;
	public Integer getBbsId() {
		return bbsId;
	}
	public void setBbsId(Integer bbsId) {
		this.bbsId = bbsId;
	}
	public String getBbsNm() {
		return bbsNm;
	}
	public void setBbsNm(String bbsNm) {
		this.bbsNm = bbsNm;
	}
	public String getBbsTypeCode() {
		return bbsTypeCode;
	}
	public void setBbsTypeCode(String bbsTypeCode) {
		this.bbsTypeCode = bbsTypeCode;
	}
	public String getBbsAttrCode() {
		return bbsAttrCode;
	}
	public void setBbsAttrCode(String bbsAttrCode) {
		this.bbsAttrCode = bbsAttrCode;
	}
	public String getReplyPosblYn() {
		return replyPosblYn;
	}
	public void setReplyPosblYn(String replyPosblYn) {
		this.replyPosblYn = replyPosblYn;
	}
	public String getFileAtchPosblYn() {
		return fileAtchPosblYn;
	}
	public void setFileAtchPosblYn(String fileAtchPosblYn) {
		this.fileAtchPosblYn = fileAtchPosblYn;
	}
	public Integer getAtchPosblFileNumber() {
		return atchPosblFileNumber;
	}
	public void setAtchPosblFileNumber(Integer atchPosblFileNumber) {
		this.atchPosblFileNumber = atchPosblFileNumber;
	}
	public Integer getAtchPosblFileSize() {
		return atchPosblFileSize;
	}
	public void setAtchPosblFileSize(Integer atchPosblFileSize) {
		this.atchPosblFileSize = atchPosblFileSize;
	}
	public String getUseYn() {
		return useYn;
	}
	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}
	public String getTmplatId() {
		return tmplatId;
	}
	public void setTmplatId(String tmplatId) {
		this.tmplatId = tmplatId;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	@Override
	public String toString() {
		return "BoardMaster [bbsId=" + bbsId + ", bbsNm=" + bbsNm
				+ ", bbsTypeCode=" + bbsTypeCode + ", bbsAttrCode="
				+ bbsAttrCode + ", replyPosblYn=" + replyPosblYn
				+ ", fileAtchPosblYn=" + fileAtchPosblYn
				+ ", atchPosblFileNumber=" + atchPosblFileNumber
				+ ", atchPosblFileSize=" + atchPosblFileSize + ", useYn="
				+ useYn + ", tmplatId=" + tmplatId + ", regDate=" + regDate
				+ "]";
	}



	

}
