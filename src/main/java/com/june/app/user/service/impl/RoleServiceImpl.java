
package com.june.app.user.service.impl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.user.model.RoleInfo;
import com.june.app.user.repository.RoleRepository;
import com.june.app.user.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
    private RoleRepository roleRepository;
  
    
    
    @Override
	@Transactional(readOnly = true)
    public Collection<RoleInfo> roleListAll() throws DataAccessException {
		return roleRepository.roleListAll();
	}
	
	
  
}
