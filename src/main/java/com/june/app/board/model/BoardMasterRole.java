
package com.june.app.board.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.june.app.cmn.model.Pagination;
import com.june.app.user.model.RoleInfo;

@Entity
@Table(name = "BBS_MST_ROLE")
public class BoardMasterRole extends Pagination{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SEQ")
	@NotNull
	private Integer seq;
	
	@Column(name = "BBS_ID")
	@NotNull
    private Integer bbsId;
	
	@Column(name = "ROLE")
	@NotNull
    private Integer role;
	
	@Column(name = "C_YN")
    private String cYn;
	
	@Column(name = "R_YN")
    private String rYn;
	
	@Column(name = "U_YN")
    private String uYn;
	
	@Column(name = "D_YN")
    private String dYn;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "role", insertable=false,updatable=false,nullable=true )
    private RoleInfo roleInfo;
	
	@ManyToOne
    @JoinColumn(name = "BBS_ID", insertable=false,updatable=false)
    private BoardMasterRole boardMasterRole;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public Integer getBbsId() {
		return bbsId;
	}

	public void setBbsId(Integer bbsId) {
		this.bbsId = bbsId;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	public String getcYn() {
		return cYn;
	}

	public void setcYn(String cYn) {
		this.cYn = cYn;
	}

	public String getrYn() {
		return rYn;
	}

	public void setrYn(String rYn) {
		this.rYn = rYn;
	}

	public String getuYn() {
		return uYn;
	}

	public void setuYn(String uYn) {
		this.uYn = uYn;
	}

	public String getdYn() {
		return dYn;
	}

	public void setdYn(String dYn) {
		this.dYn = dYn;
	}

	public RoleInfo getRoleInfo() {
		return roleInfo;
	}

	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}

	public BoardMasterRole getBoardMasterRole() {
		return boardMasterRole;
	}

	public void setBoardMasterRole(BoardMasterRole boardMasterRole) {
		this.boardMasterRole = boardMasterRole;
	}

	@Override
	public String toString() {
		return "BoardMasterRole [seq=" + seq + ", bbsId=" + bbsId + ", role="
				+ role + ", cYn=" + cYn + ", rYn=" + rYn + ", uYn=" + uYn
				+ ", dYn=" + dYn + ", roleInfo=" + roleInfo
				+ ", boardMasterRole=" + boardMasterRole + "]";
	}
	
	

}
