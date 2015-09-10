package com.sdjz.testService;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Role;
import com.sdjz.service.RoleService;

public class RoleTest {
	RoleService roleService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		roleService=(RoleService)ac.getBean("roleService");
	}
	@Test
	public void save(){
		List<Role> roles=new ArrayList<Role>();
		roles.add(new Role("student"));
		roles.add(new Role("tutor"));
		roles.add(new Role("teacher"));
		roles.add(new Role("secretary"));
		roleService.saveRoles(roles);
	}
	@Test
	public void findByDescription(){
		System.out.println("roleByDescription:"+roleService.findByDescription("student").getDescription());
	}
	@Test
	public void findById(){
		System.out.println("roleById:"+roleService.findById(1).getDescription());
	}
	@Test
	public void findAll(){
		List<Role> roles=roleService.findAll();
		for(Role role:roles){
			System.out.println("role:"+role.getDescription());
		}
	}

}
