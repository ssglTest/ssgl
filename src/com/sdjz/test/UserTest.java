package com.sdjz.test;



import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Role;
import com.sdjz.domain.User;
import com.sdjz.service.UserService;

public class UserTest {
	private UserService userService;
	
	@Before
	public void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService)ac.getBean("userService");
	}
	
	@Test
	public void getRole(){
		User user = userService.findById(1);
		List<Role> roles = user.getRoles();
		for(Role role : roles){
			System.out.println("userRole:"+role);
		}
	}

}
