package com.june.app.main.web;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller
public class MainController {
	
	private static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String home(Locale locale, 
			HttpServletRequest request,
			Model model) {
		
		/*Login logininfo = (Login) request.getSession().getAttribute("loginInfo");
		
		logger.debug("=====] call logininfo [===== {}", logininfo.toString());*/
		return "main/main";
	}
	
}
