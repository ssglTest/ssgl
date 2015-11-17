package com.sdjz.loginController;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdjz.domain.Resource;
import com.sdjz.domain.Role;
import com.sdjz.domain.User;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.UserService;

@Controller
@RequestMapping("userContro")
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("/login.html")
	public String login() {
		return "login/login";
	}

	public String reLogin(ModelMap modelMap) {
		modelMap.put("info", "请重新登录");
		return "login/login";
	}

	@RequestMapping("/index.html")
	public String index(ModelMap modelMap,HttpSession httpSession){
		User storedUser = userService.findById(CommonHelp.getCurrentUser(httpSession).getId());
		Set<Resource> parentResources = new HashSet<Resource>();
		for(Role role : storedUser.getRoles()){
			for(Resource resource : role.getResources()){
				parentResources.add(resource);
			}
		}
		return null;
	}
}
