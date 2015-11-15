package com.sdjz.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Role;
import com.sdjz.domain.User;
import com.sdjz.service.RoleService;
import com.sdjz.service.UserService;

public class User_RoleTest {
	UserService userService;
	RoleService roleService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		roleService=(RoleService)ac.getBean("roleService");
		userService=(UserService)ac.getBean("userService");
	}
	@Test
	public void addRole(){
		User user=userService.findById(1);
		Role role=roleService.findById(2);
		user.addRole(role);
		userService.update(user);
	}
	@Test
	public void removeRole(){
		
	}

}
