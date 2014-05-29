package com.june.app.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.user.model.UserRoleInfo;
import com.june.app.user.repository.UserRoleRepository;
import com.june.app.user.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
    private UserRoleRepository userRoleRepository;
  

	@Override
	@Transactional(readOnly = true)
	public void save (UserRoleInfo vo) throws DataAccessException {
		userRoleRepository.save(vo);
	}
    
    
  
}
