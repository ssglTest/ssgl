package com.sdjz.loginController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sdjz.domain.Resource;
import com.sdjz.domain.RoleResource;
import com.sdjz.domain.User;
import com.sdjz.domain.UserRole;
import com.sdjz.help.CommonHelp;
import com.sdjz.other.ResourceByIdComparator;
import com.sdjz.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login.html")
	public String login() {
		return "login/login";
	}
	
	@RequestMapping("/logout.html")
	public String logout(ModelMap modelMap,HttpSession httpSession){
		httpSession.invalidate();
		modelMap.put("info", "请重新登录");
		return "login/login";
	}

	@RequestMapping("/reLogin.html")
	public String reLogin(ModelMap modelMap) {
		modelMap.put("info", "请重新登录");
		return "login/login";
	}

	@RequestMapping("/index.html")
	public String index(ModelMap modelMap, HttpSession httpSession) {
		System.out.println("index.html");
		User storedUser = userService.findById(CommonHelp.getCurrentActor(httpSession).getId());
		Set<Resource> parentResources = new HashSet<Resource>();
		for (UserRole userRole : storedUser.getUserRoles()) {
			for (RoleResource roleResource : userRole.getRole().getRoleResources()) {
				parentResources.add(roleResource.getResource().getParent());
			}
		}

		ArrayList<Resource> parentResourceList = new ArrayList<Resource>(parentResources);
		Collections.sort(parentResourceList, new ResourceByIdComparator());
		Set<Resource> childResources = new HashSet<Resource>();
		for (UserRole userRole : storedUser.getUserRoles()) {
			for (RoleResource roleResource : userRole.getRole().getRoleResources()) {
				childResources.add(roleResource.getResource());
			}
		}

		ArrayList<Resource> childResourceList = new ArrayList<Resource>(childResources);
		Collections.sort(childResourceList, new ResourceByIdComparator());
		modelMap.addAttribute("parentResourceList", parentResourceList);
		modelMap.addAttribute("childResourceList", childResourceList);
		modelMap.addAttribute("user", storedUser);
		modelMap.addAttribute("username",storedUser.getActor().getName());
		return "login/index";
	}
}
