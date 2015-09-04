package com.sdjz.login;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("loginContro")
public class LoginController {

	@RequestMapping("login")
	public String login(HttpSession session,String username,String password,String role){
		
		//....
		session.setAttribute("username", username);
		return null;
	}
	
	@RequestMapping("logout")
	public String logout(){
		return null;
	}
	
}
