package com.june.app.user.service;

import org.springframework.dao.DataAccessException;

import com.june.app.user.model.UserRoleInfo;

public interface UserRoleService {

	public void save(UserRoleInfo vo) throws DataAccessException;

}
