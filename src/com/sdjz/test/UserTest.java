package com.sdjz.test;



import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Role;
import com.sdjz.domain.Secretary;
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
	public void getRole(){
		Secretary secretary=secretaryService.findByNo("1001");
		User user=new User("1001","1001");
		userService.saveUser(user);
		secretary.setUser(user);
		
	}

}
