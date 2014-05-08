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
package com.june.app.site.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.june.app.cmn.model.Pagination;
import com.june.app.user.model.UserInfo;

/**
 * Simple JavaBean domain object representing an person.
 * 
 * @author Ken Krebs
 */
@Entity
@Table(name = "BBS_YOUTUBE")
public class Video extends Pagination {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "NTT_ID")
	private Integer nttId;

	@Column(name = "NTT_SJ")
	@NotEmpty
	private String nttSj;
	
	@Column(name = "NTT_LINK")
	@NotEmpty
	private String nttLink;
	
	@Column(name = "NTT_CN")
	@NotEmpty
	private String nttCn;
	
	@Column(name = "RDCNT")
	private Integer rdcnt = 0;
	
	@Column(name = "USE_YN")
	private String useYn;
	
	@Column(name = "DISPLAY_DIV")
	@NotEmpty
	private String displayDiv;
	
	@Column(name = "FRST_REGIST_PNTTM")
	private Date frstRegistPnttm;
	
	@Column(name = "FRST_REGISTER_ID")
	private String frstRegisterId;
	
	@Column(name = "LAST_UPDT_PNTTM")
	private Date lastUpdtPnttm;
	
	@Column(name = "LAST_UPDUSR_ID")
	private String lastUpdusrId;
	
	
	@ManyToOne()
    @JoinColumn(name = "FRST_REGISTER_ID", insertable=false,updatable=false)
    private UserInfo user;
	
	public Integer getNttId() {
		return nttId;
	}
	public void setNttId(Integer nttId) {
		this.nttId = nttId;
	}
	public String getNttSj() {
		return nttSj;
	}
	public void setNttSj(String nttSj) {
		this.nttSj = nttSj;
	}
	public String getNttLink() {
		return nttLink;
	}
	public void setNttLink(String nttLink) {
		this.nttLink = nttLink;
	}
	public String getNttCn() {
		return nttCn;
	}
	public void setNttCn(String nttCn) {
		this.nttCn = nttCn;
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
	public String getDisplayDiv() {
		return displayDiv;
	}
	public void setDisplayDiv(String displayDiv) {
		this.displayDiv = displayDiv;
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
	public UserInfo getUser() {
		return user;
	}
	public void setUser(UserInfo user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Video [nttId=" + nttId + ", nttSj=" + nttSj + ", nttLink="
				+ nttLink + ", nttCn=" + nttCn + ", rdcnt=" + rdcnt
				+ ", useYn=" + useYn + ", displayDiv=" + displayDiv
				+ ", frstRegistPnttm=" + frstRegistPnttm + ", frstRegisterId="
				+ frstRegisterId + ", lastUpdtPnttm=" + lastUpdtPnttm
				+ ", lastUpdusrId=" + lastUpdusrId + ", user=" + user + "]";
	}
	
	
	
	
	
	

}
