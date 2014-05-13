package com.june.app.user.service.impl;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AbstractAuthenticationTargetUrlRequestHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.june.app.user.model.Login;
import com.june.app.user.model.UserInfo;
import com.june.app.user.repository.UserRepository;


public class LoginSuccessHandlerImpl  extends AbstractAuthenticationTargetUrlRequestHandler implements AuthenticationSuccessHandler
{
	 
	private static final Logger logger = LoggerFactory.getLogger(LoginSuccessHandlerImpl.class);
	
	@Autowired
    UserRepository userRepository;
	public LoginSuccessHandlerImpl() {
    }
	
	public LoginSuccessHandlerImpl(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }
	
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
    	
     Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     
     
     if (principal != null && principal instanceof UserDetails) {
    	 String userName = ((UserDetails) principal).getUsername();
    	 
    	 UserInfo userInfos = userRepository.getUser(userName);
    	 /**패스워드는 세션에 담지 않는다*/
    	 userInfos.setPassword("");
    	 userInfos.getUserRoleInfo();
    	 
    	 Login login  = new Login();
    	 boolean isLogin = true;
    	 
    	 login.setLogin(isLogin);
    	 login.setUserInfo(userInfos);
    	 request.getSession().setAttribute("loginInfo", login);
     }
     handle(request, response, authentication);
     clearAuthenticationAttributesCus(request);
     
     
     //getRedirectStrategy().sendRedirect(request, response, "");
     //.sendRedirect(request, response, url);
     
    }
	
	protected final void clearAuthenticationAttributesCus(HttpServletRequest request) {
        HttpSession session = request.getSession(false);

        if (session == null) {
            return;
        }

        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
}

