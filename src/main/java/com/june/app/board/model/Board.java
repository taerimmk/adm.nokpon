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

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Simple JavaBean domain object representing an person.
 * 
 * @author Ken Krebs
 */
@Entity
@Table(name = "BBS_NTT")
public class Board extends PageEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NTT_ID")
	private long nttId;

	@Column(name = "BBS_ID")
	@NotNull
	private Integer bbsId;

	@Column(name = "NTT_NO")
	private String nttNo;

	@Column(name = "NTT_SJ")
	@NotEmpty
	private String nttSj;

	@Column(name = "NTT_CN")
	private String nttCn;

	@Column(name = "ANSWER_YN")
	private Integer answerYn;

	@Column(name = "PARNTSCTT_NO")
	private Integer parntscttNo;

	@Column(name = "ANSWER_LC")
	private Integer answerLc;

	@Column(name = "SORT_ORDR")
	private Integer sortOrdr;

	@Column(name = "RDCNT")
	private Integer rdcnt;

	@NotEmpty
	@Column(name = "USE_YN")
	private String useYn;

	@Column(name = "ATCH_FILE_ID")
	private String atchFileId;

	@Column(name = "FRST_REGIST_PNTTM")
	private Date frstRegistPnttm;

	@Column(name = "FRST_REGISTER_ID")
	private String frstRegisterId;

	@Column(name = "LAST_UPDT_PNTTM")
	private Date lastUpdtPnttm;

	@Column(name = "LAST_UPDUSR_ID")
	private String lastUpdusrId;

	public long getNttId() {
		return nttId;
	}

	public void setNttId(long nttId) {
		this.nttId = nttId;
	}

	public Integer getBbsId() {
		return bbsId;
	}

	public void setBbsId(Integer bbsId) {
		this.bbsId = bbsId;
	}

	public String getNttNo() {
		return nttNo;
	}

	public void setNttNo(String nttNo) {
		this.nttNo = nttNo;
	}

	public String getNttSj() {
		return nttSj;
	}

	public void setNttSj(String nttSj) {
		this.nttSj = nttSj;
	}

	public String getNttCn() {
		return nttCn;
	}

	public void setNttCn(String nttCn) {
		this.nttCn = nttCn;
	}

	public Integer getAnswerYn() {
		return answerYn;
	}

	public void setAnswerYn(Integer answerYn) {
		this.answerYn = answerYn;
	}

	public Integer getParntscttNo() {
		return parntscttNo;
	}

	public void setParntscttNo(Integer parntscttNo) {
		this.parntscttNo = parntscttNo;
	}

	public Integer getAnswerLc() {
		return answerLc;
	}

	public void setAnswerLc(Integer answerLc) {
		this.answerLc = answerLc;
	}

	public Integer getSortOrdr() {
		return sortOrdr;
	}

	public void setSortOrdr(Integer sortOrdr) {
		this.sortOrdr = sortOrdr;
	}

	public Integer getRdcnt() {
		return rdcnt;
	}

	public void setRdcnt(Integer rdcnt) {
		this.rdcnt = rdcnt;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(String atchFileId) {
		this.atchFileId = atchFileId;
	}

	public Date getFrstRegistPnttm() {
		return frstRegistPnttm;
	}

	public void setFrstRegistPnttm(Date frstRegistPnttm) {
		this.frstRegistPnttm = frstRegistPnttm;
	}

	public String getFrstRegisterId() {
		return frstRegisterId;
	}

	public void setFrstRegisterId(String frstRegisterId) {
		this.frstRegisterId = frstRegisterId;
	}

	public Date getLastUpdtPnttm() {
		return lastUpdtPnttm;
	}

	public void setLastUpdtPnttm(Date lastUpdtPnttm) {
		this.lastUpdtPnttm = lastUpdtPnttm;
	}

	public String getLastUpdusrId() {
		return lastUpdusrId;
	}

	public void setLastUpdusrId(String lastUpdusrId) {
		this.lastUpdusrId = lastUpdusrId;
	}

	@Override
	public String toString() {
		return "Board [nttId=" + nttId + ", bbsId=" + bbsId + ", nttNo="
				+ nttNo + ", nttSj=" + nttSj + ", nttCn=" + nttCn
				+ ", answerYn=" + answerYn + ", parntscttNo=" + parntscttNo
				+ ", answerLc=" + answerLc + ", sortOrdr=" + sortOrdr
				+ ", rdcnt=" + rdcnt + ", useYn=" + useYn + ", atchFileId="
				+ atchFileId + ", frstRegistPnttm=" + frstRegistPnttm
				+ ", frstRegisterId=" + frstRegisterId + ", lastUpdtPnttm="
				+ lastUpdtPnttm + ", lastUpdusrId=" + lastUpdusrId + "]";
	}

}
