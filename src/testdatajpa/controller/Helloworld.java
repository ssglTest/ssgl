package testdatajpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import testdatajpa.domain.User;
import testdatajpa.service.UserService;

@Controller
public class Helloworld {
	@Autowired
	UserService userService;
	@RequestMapping("/hello.html")
	public ModelAndView helloworld(@RequestParam(value="name") String name)throws Exception{
		String message=name+"welcome";
		ModelAndView view =new ModelAndView();
		List<User> users=userService.findAll();
		for(User user:users){
			view.addObject("username",user.getName());
		}
		view.addObject("message", message);
		view.setViewName("helloworld");
		return view;
		
	}

}
