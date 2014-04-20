package com.june.app.cmn.web;

import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.june.app.cmn.model.Pagination;

/**
 * Handles requests for the application home page.
 */
@Controller
public class PaginationController {
	
	private static final Logger logger = LoggerFactory.getLogger(PaginationController.class);
	
	@RequestMapping(value = "/pagination", method = RequestMethod.GET)
	public String paginationView(Locale locale,
			@ModelAttribute("pagination") Pagination pagination,
			Model model) {
		logger.debug("=====] call paginationView [===== {}",pagination.toString());
		
		
		return "cmn/paginationView";
	}
	
	
}
