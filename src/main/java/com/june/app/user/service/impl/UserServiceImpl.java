package com.june.app.user.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.user.model.UserInfo;
import com.june.app.user.repository.UserRepository;
import com.june.app.user.service.UserService;

@Service
public class UserServiceImpl implements UserService {

  
    private UserRepository userRepository;
  

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        
        this.userRepository = userRepository;
    }


    @Override
    @Transactional(readOnly = true)
    public UserInfo getUser(Integer seq) throws DataAccessException {
        return userRepository.getUser(seq);
    }
    
    
    @Override
	@Transactional(readOnly = true)
	public Map<?,?> userList (UserInfo vo) throws DataAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userList", userRepository.userList(vo));
		map.put("userListCnt", userRepository.userListCnt(vo));
		return map;
	}
	
	
	@Override
	@Transactional(readOnly = true)
	public void save (UserInfo vo) throws DataAccessException {
		userRepository.save(vo);
	}
    
    
  
}
