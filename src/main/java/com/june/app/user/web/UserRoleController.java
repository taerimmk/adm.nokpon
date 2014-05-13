package com.june.app.user.web;

import java.util.Collection;
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

import com.june.app.user.model.RoleInfo;
import com.june.app.user.model.UserInfo;
import com.june.app.user.model.UserRoleInfo;
import com.june.app.user.model.UserRoleInfos;
import com.june.app.user.service.RoleService;
import com.june.app.user.service.UserRoleService;
import com.june.app.user.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class UserRoleController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserRoleController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private UserRoleService userRoleService;

	
	@RequestMapping(value = "/user/role/list/{pageIndex}", method = RequestMethod.GET)
	public String UserRoleList(Locale locale,
			@ModelAttribute("user") UserInfo user,
			@ModelAttribute("userRoleInfo") UserRoleInfo userRoleInfo,
			@PathVariable int pageIndex,
			Model model) 
	{
		/**페이지당 보여주는 게시물 수*/
		user.setPageSize(2);
		/**현재 페이지*/
		user.setPageIndex(pageIndex);	
		Map<?,?> userList = userService.userList(user);
		Collection<RoleInfo> roleList = roleService.roleListAll();
		long totalCnt = (long) userList.get("userListCnt");
		user.setTotalCnt(totalCnt);
		
		model.addAttribute("roleList",  roleList );
		model.addAttribute("userList",  userList.get("userList") );
		model.addAttribute("userListCnt", totalCnt );
		
		return "user/roleList";
	}
	
	@RequestMapping(value = "/user/role/save/{pageIndex}", method = RequestMethod.POST)
	public String UserRoleSave(Locale locale,
			@ModelAttribute("userRoleInfos") UserRoleInfos userRoleInfos,
			@PathVariable int pageIndex,
			Model model) 
	{
		
		
		for (UserRoleInfo userRoleInfo: userRoleInfos.getUserRoleInfos()){
			try {
				//UserRoleInfo userRoleInfoSave = new UserRoleInfo();
				//userRoleInfoSave = userRoleInfo;
				userRoleService.save(userRoleInfo);
				
			} catch (Exception e) {
				logger.debug("=============] UserRoleSave Err [============ {}", e);
			}
			
		}
				
		return "redirect:/user/role/list/{pageIndex}";
	}
	
	
}
