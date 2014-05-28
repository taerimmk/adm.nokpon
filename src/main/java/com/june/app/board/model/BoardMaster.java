
package com.june.app.board.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import com.june.app.cmn.model.Pagination;

@Entity
@Table(name = "BBS_MST")
public class BoardMaster extends Pagination{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BBS_ID")
	private Integer bbsId;
	
    @Column(name = "BBS_NM")
    @NotEmpty
    private String bbsNm;
	
    @Column(name = "BBS_TYPE_CODE")
    private String bbsTypeCode;
    
    @Column(name = "BBS_ATTR_CODE")
    private String bbsAttrCode;
    
    @Column(name = "ANSWER_POSBL_YN")
    private String answerPosblYn;
    
    @Column(name = "COMNT_POSBL_YN")
    private String comntPosblYn;
    
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
    
    @Column(name = "REGI_DATE")
    private Date regiDate;
    
    
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "boardMasterRole",fetch = FetchType.EAGER)
    private Set<BoardMasterRole> boardMasterRoles;
    
    
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

	public String getAnswerPosblYn() {
		return answerPosblYn;
	}

	public void setAnswerPosblYn(String answerPosblYn) {
		this.answerPosblYn = answerPosblYn;
	}

	public String getComntPosblYn() {
		return comntPosblYn;
	}

	public void setComntPosblYn(String comntPosblYn) {
		this.comntPosblYn = comntPosblYn;
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

	public Date getRegiDate() {
		return regiDate;
	}

	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}

	public Set<BoardMasterRole> getBoardMasterRoles() {
		return boardMasterRoles;
	}

	public void setBoardMasterRoles(Set<BoardMasterRole> boardMasterRoles) {
		this.boardMasterRoles = boardMasterRoles;
	}

	

	

	
}
