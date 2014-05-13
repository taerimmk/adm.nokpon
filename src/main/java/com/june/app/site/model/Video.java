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
	
	@Column(name = "REGI_DATE", updatable=false)
	//@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date regiDate;
	
	@Column(name = "REGI_ID", updatable=false)
	private Integer regiId;
	
	@Column(name = "UPDT_DATE")
	private Date updtDate;
	
	@Column(name = "UPDT_ID")
	private Integer updtId;
	
	
	@ManyToOne()
    @JoinColumn(name = "REGI_ID", insertable=false,updatable=false)
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


	public Date getRegiDate() {
		return regiDate;
	}


	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}


	public Integer getRegiId() {
		return regiId;
	}


	public void setRegiId(Integer regiId) {
		this.regiId = regiId;
	}


	public Date getUpdtDate() {
		return updtDate;
	}


	public void setUpdtDate(Date updtDate) {
		this.updtDate = updtDate;
	}


	public Integer getUpdtId() {
		return updtId;
	}


	public void setUpdtId(Integer updtId) {
		this.updtId = updtId;
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
				+ ", regiDate=" + regiDate + ", regiId=" + regiId
				+ ", updtDate=" + updtDate + ", updtId=" + updtId + ", user="
				+ user + "]";
	}


	
	

}
