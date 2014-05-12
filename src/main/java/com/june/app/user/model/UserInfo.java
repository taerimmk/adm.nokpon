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
package com.june.app.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.june.app.cmn.model.Pagination;


/**
 * Simple JavaBean domain object representing an person.
 * 
 * @author Ken Krebs
 */
@Entity
//@JsonSerialize
@Table(name = "NOK_USER")
public class UserInfo extends Pagination {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "seq")
	protected Integer seq;
	
	@Column(name = "USER_ID")
    @NotEmpty
	protected String userId;
	
	@Column(name = "name")
    @NotEmpty
	protected String name;
	
	@Column(name = "email")
	protected String email;
	
	@Column(name = "status")
	protected String status;
	
	
	@Column(name = "password")
	private String password;
	
	/*@OneToOne
	@JoinColumn(name="seq")
    private UserRoleInfo userRoleInfo;*/
	
	@OneToOne(optional = true)
	@JoinColumn(name = "seq", referencedColumnName = "user",insertable = false, updatable = false)
	private UserRoleInfo userRoleInfo;

	public Integer getSeq() {
		return seq;
	}

	public void setSeq(Integer seq) {
		this.seq = seq;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRoleInfo getUserRoleInfo() {
		return userRoleInfo;
	}

	public void setUserRoleInfo(UserRoleInfo userRoleInfo) {
		this.userRoleInfo = userRoleInfo;
	}	
	
	
	

}
