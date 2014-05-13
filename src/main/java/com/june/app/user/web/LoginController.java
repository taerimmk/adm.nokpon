package com.june.app.user.web;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 * 
 * @param <getAuthUser>
 */
@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory
			.getLogger(LoginController.class);

	@RequestMapping(value = "/user/welcome", method = RequestMethod.GET)
	public String printWelcomeUser() {
		return "hello";
	}

	@RequestMapping(value = "/admin/welcome", method = RequestMethod.GET)
	public String printWelcomeAdmin() {
		return "admin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginPage(Model model, HttpServletRequest request) {
		String referrer = request.getHeader("Referer");
		logger.info("=============] referrer [============ {}", referrer);
		if (referrer != null) {
			request.getSession().setAttribute("url_prior_login", referrer);
		}

		return "login/login";
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String getHomePage(Model model) {
		return "hello";
	}

	@RequestMapping(value = "/accessdenied", method = RequestMethod.GET)
	public String getFailurePage(Model model) {
		return "failure";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String getLogoutPage(Model model, HttpServletRequest req) {
		req.getSession().invalidate();
		return "logout";
	}

	@RequestMapping(value = "/loginSuccess", method = RequestMethod.GET)
	public String loginSuccess(Model model, HttpServletRequest req) {

		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			/** login session det ID */
			String userName = ((UserDetails) principal).getUsername();
			// User loginUser = userService.findUserByEmail(email);
			// return new SecurityUser(loginUser);
		}
		return "redirect:/main";
	}

}
