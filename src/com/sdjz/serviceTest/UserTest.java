package com.sdjz.serviceTest;


import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.User;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.UserService;

public class UserTest {
	 UserService userService;
	 SecretaryService secretaryService;
	
	@Before
	public void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
		userService = (UserService)ac.getBean("userService");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
	}
	
	@Test
	public void findByUserName(){
		User user=userService.findByUserName("111");
		System.out.println("userName========"+user.getUserName());
	}

}
