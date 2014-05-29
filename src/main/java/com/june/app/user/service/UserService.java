package com.june.app.user.service;

import java.util.Map;

import org.springframework.dao.DataAccessException;

import com.june.app.user.model.UserInfo;

public interface UserService {

	public UserInfo getUser(Integer seq) throws DataAccessException;

	public Map<?, ?> userList(UserInfo vo) throws DataAccessException;

	public void save(UserInfo vo) throws DataAccessException;

}
