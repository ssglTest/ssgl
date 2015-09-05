package com.sdjz.login;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sdjz.domain.Role;
import com.sdjz.domain.User;
import com.sdjz.service.UserService;

@Controller
@RequestMapping("userContro")
public class LoginController {

	@Autowired
	private UserService userService;
/*
	@RequestMapping("/reLogin.html")
	public String reLogin(){
		return null;
	}*/
	@RequestMapping(value = "/login.html",method=RequestMethod.POST)
	public String login(HttpSession session, String username, String password, String role, ModelMap modelMap) {
		User user = userService.findByUserName(username);
		if (user == null) {
			modelMap.put("message", "用户名不存在");
			return "login/relogin";
		}
		
		session.setAttribute("user", user);
		String pd = user.getPassword();
		if (!password.equals(pd)) {
			modelMap.put("message", "密码错误");
			return "login/relogin";
		}
		//在取出集合进行遍历前，要先对集合是否为空进行判断
		List<Role> roles = user.getRoles();
		System.out.println(roles);
		for(Role myRole : roles){
			String userRole = myRole.getDescription();
			if(userRole == role){
				return "test/success";
			}
		}
		modelMap.put("message", "请选择正确的类型");
		return "login/relogin";
		
	}

	// 鐢ㄤ簬瑙﹀彂鏍囩鍔熻兘
	/*@RequestMapping("/reLogin.html")
	public String reLogin(ModelMap map) {
		map.put("message", "璇烽噸鏂扮櫥褰�");
		return "login/login";
	}*/

	@RequestMapping("/hello.html")
	public String info() {
		System.out.println("========hello===========");
		return "test/success";
	}

	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login/login";
	}

}
