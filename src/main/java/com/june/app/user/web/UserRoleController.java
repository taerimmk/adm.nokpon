package com.june.app.user.web;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.june.app.user.model.UserInfo;
import com.june.app.user.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserRoleController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	
	
	private final UserService userService;


    @Autowired
    public UserRoleController(UserService userService) {
        this.userService = userService;
    }
	
	@RequestMapping(value = "/user/role/{pageIndex}", method = RequestMethod.GET)
	public String UserRoleList(Locale locale,
			@ModelAttribute("user") UserInfo user,
			@PathVariable int pageIndex,
			Model model) 
	{
		/**페이지당 보여주는 게시물 수*/
		user.setPageSize(2);
		/**현재 페이지*/
		user.setPageIndex(pageIndex);	
		Map<?,?> userList = userService.userList(user);
		long totalCnt = (long) userList.get("userListCnt");
		user.setTotalCnt(totalCnt);
		
		model.addAttribute("userList",  userList.get("userList") );
		model.addAttribute("userListCnt", totalCnt );
		
		return "user/roleList";
	}
	
}
