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
	public void specification(){
		Role roles=roleService.findOne("no","001");
		
		System.out.println(roles.getDescription());
	}
	@Test
	public void likeQuery(){
		List<Role> roles=roleService.likeQuery("no","00");
		for(Role role:roles){
		System.out.println(role.getDescription());
		}
	}
	@Test
	public void pageQuery(){
		List<Role> roles=roleService.pageQuery("no","00");
		for(Role role:roles){
			System.out.println(role.getDescription());
			}
	}

}
