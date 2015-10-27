package com.sdjz.serviceTest;


import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Role;
import com.sdjz.service.RoleService;

public class RoleServiceTest {
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
		roleService.saves(roles);
	}
	@Test
	public void findAll(){
		List<Role> roles = roleService.findAll();
		for(Role role:roles){
		System.out.println(role.getDescription());
		}
	}
	@Test
	public void findByDescription(){
		Role role = roleService.findByDescription("student");
		System.out.println("role Descroiption======"+role.getDescription());
	}
	@Test
	public void criteria(){
		Role role=roleService.getResult(Role.class, "no","001");		
			System.out.println(role.getDescription());
	}
	@Test
	public void likeQuery(){
		List<Role> roles=roleService.likeQuery(Role.class, "no", "00");
		for(Role role:roles){
			System.out.println(role.getDescription());
		}
	}

}
