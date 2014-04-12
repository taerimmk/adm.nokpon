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
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonBackReference;


/**
 * Simple JavaBean domain object representing an person.
 * 
 * @author Ken Krebs
 */
@Entity
@Table(name = "NOK_USER_ROLE")
public class RoleInfo {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)	
	protected Integer seq;
	
	
	@Column(name = "role")
    @NotEmpty
	protected String role;
	
	
	@ManyToOne
    @JoinColumn(name = "user_id")
	//@JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserInfo userInfo;


	public Integer getSeq() {
		return seq;
	}


	public void setSeq(Integer seq) {
		this.seq = seq;
	}
	


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}

	@JsonBackReference
	public UserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	
	
	
}
