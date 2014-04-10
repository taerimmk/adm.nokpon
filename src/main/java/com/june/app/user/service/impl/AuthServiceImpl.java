package com.june.app.user.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.user.model.UserInfo;
import com.june.app.user.repository.UserRepository;
import com.june.app.user.service.IAuthService;
import com.june.app.user.web.LoginController;

@Service
public class AuthServiceImpl implements IAuthService, UserDetailsService {

	private static final Logger logger = LoggerFactory.getLogger(AuthServiceImpl.class);	
	private UserRepository userRepository;
	  
	
    @Autowired
    public AuthServiceImpl(UserRepository userRepository) {
        
        this.userRepository = userRepository;
    }

	@Transactional
	@Override
	public UserDetails loadUserByUsername(String id)
			throws UsernameNotFoundException {

		logger.debug("details id ==========={}",id);	
		UserInfo userInfo = userRepository.getUser(id);
		logger.debug("details ==========={}",userInfo.getId());
		logger.debug("details list ==========={}",userInfo.getRoleInfos());
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		/*SimpleGrantedAuthority userAuthority = new SimpleGrantedAuthority(details.getRole());*/
		/*SimpleGrantedAuthority adminAuthority = new SimpleGrantedAuthority(
				"ROLE_ADMIN");
		
		authorities.add(userAuthority);*/
		
		/*if (details.getRole().equals("user"))
			authorities.add(userAuthority);
		else if (details.getRole().equals("admin")) {
			authorities.add(userAuthority);
			authorities.add(adminAuthority);
		}*/
		UserDetails user = new User(userInfo.getId(),
				userInfo.getPassword(), true, true, true, true, authorities);
		return user;
	}
}
