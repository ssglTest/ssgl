package com.sdjz.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.School;
import com.sdjz.service.SchoolService;

public class SchoolTest {
	SchoolService schoolService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		schoolService=(SchoolService)ac.getBean("shoolService");
		
	}
	@Test
	public void save(){
		School school=new School("管理学院");
		schoolService.saveSchool(school);
	}
}
