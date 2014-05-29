
package com.june.app.user.service;

import java.util.Collection;

import org.springframework.dao.DataAccessException;

import com.june.app.user.model.RoleInfo;

public interface RoleService {

	public Collection<RoleInfo> roleListAll() throws DataAccessException;

}
