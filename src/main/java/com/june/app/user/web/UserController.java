package com.june.app.user.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.june.app.user.model.User;
import com.june.app.user.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	private final UserService userService;


    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/selectUser", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		User selectUser = userService.selectUser(1);
		
		model.addAttribute("selectUser", selectUser );
		
		return "home";
	}
	
}
