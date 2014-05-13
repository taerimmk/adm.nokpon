package com.june.app.user.model;

import java.util.Date;

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

import org.hibernate.validator.constraints.NotEmpty;


/**
 * Simple JavaBean domain object representing an person.
 * 
 * @author Ken Krebs
 */
@Entity
@Table(name = "NOK_USER_ROLE")
public class UserRoleInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	protected Integer seq;
	
	@Column(name = "user")
	@NotNull
	protected Integer user;
	
	@Column(name = "role")
	@NotNull
	protected Integer role;
	
	@Column(name = "REGI_DATE", updatable=false)
	protected Date regiDate;
	
	
	@ManyToOne(cascade=CascadeType.MERGE)
    @JoinColumn(name = "role", insertable=false,updatable=false)
    private RoleInfo roleInfo;


	public Integer getSeq() {
		return seq;
	}


	public void setSeq(Integer seq) {
		this.seq = seq;
	}


	public Integer getUser() {
		return user;
	}


	public void setUser(Integer user) {
		this.user = user;
	}


	public Integer getRole() {
		return role;
	}


	public void setRole(Integer role) {
		this.role = role;
	}


	public Date getRegiDate() {
		return regiDate;
	}


	public void setRegiDate(Date regiDate) {
		this.regiDate = regiDate;
	}


	public RoleInfo getRoleInfo() {
		return roleInfo;
	}


	public void setRoleInfo(RoleInfo roleInfo) {
		this.roleInfo = roleInfo;
	}


	@Override
	public String toString() {
		return "UserRoleInfo [seq=" + seq + ", user=" + user + ", role=" + role
				+ ", regiDate=" + regiDate + ", roleInfo=" + roleInfo + "]";
	}

}
