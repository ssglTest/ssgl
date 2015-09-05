package com.sdjz.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userContro")
public class LoginController {

	@RequestMapping("/login.html")
	public String login(HttpSession session,String username,String password,String role){
		System.out.println("username:"+username+"   password:"+password+"    role: "+role);
		//....
		session.setAttribute("username", username);
		return "test/success";
	}
	
	//用于触发标签功能
	@RequestMapping("/reLogin.html")
	public String reLogin(ModelMap map){
		map.put("message", "请重新登录");
		return "login/login";
	}
	
	@RequestMapping("/hello.html")
	public String info(){
		System.out.println("========hello===========");
		return "test/success";
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "login/login";
	}
	
}
