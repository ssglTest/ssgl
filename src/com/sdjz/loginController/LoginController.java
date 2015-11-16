package com.sdjz.loginController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sdjz.domain.Major;
import com.sdjz.domain.Role;
import com.sdjz.domain.School;
import com.sdjz.domain.User;
import com.sdjz.service.MajorService;
import com.sdjz.service.SchoolService;
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
	public String login(HttpSession httpSession, String username, String password, String role, ModelMap modelMap) {
		User user = userService.findByUserName(username);
		if (user == null) {
			modelMap.put("message", "用户名不存在");
			return "login/relogin";
		}
		
		httpSession.setAttribute("user", user);
		String pd = user.getPassword();
		if (!password.equals(pd)) {
			modelMap.put("message", "密码错误");
			return "login/relogin";
		}
		System.out.println("得到的role:"+role);
		/*String savedRole =user.getRole().getDescription();//用户在数据库中已保存的角色
*/		String name = user.getActor().getName();
		modelMap.put("username", name);
		/*if(savedRole.equals(role) ){
			if(savedRole.equals("student")){
				return "login/studentSignIn";
			}else if(savedRole.equals("tutor")){
				return "login/tutorSignIn";
			}else if(savedRole.equals("secretary")){
				return "login/secretarySignIn";
			}else if(savedRole.equals("teacher")){
				return "login/teacherSignIn";
			}
		}*/
		modelMap.put("message", "类型错误");
		return "login/relogin";
		
	}

	@RequestMapping("/hello.html")
	public String info() {
		System.out.println("========hello===========");
		return "test/success";
	}

	@RequestMapping("logout")
	public String logout(HttpSession httpSession) {
		httpSession.invalidate();
		return "login/relogin";
	}
	
	/*@RequestMapping("/informationTest.html")
	public String informationTest(){
		return "information/bootstrapStudentTest";
	}*/

}
