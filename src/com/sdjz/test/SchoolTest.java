package com.sdjz.test;

import java.util.ArrayList;
import java.util.List;

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
		List<School> schools=new ArrayList<School>();
		schools.add(new School("AA"));
		schools.add(new School("BB"));
		schoolService.saveSchools(schools);
	}
	@Test
	public void findById(){
		System.out.println("School:" +schoolService.findById(1).getDescription());
	}
	@Test
	public void findByName(){
		System.out.println("schoolByname:"+schoolService.findByName("AA"));
	}
	@Test
	public void findAll(){
		List<School> schools =schoolService.findAll();
		for(School school:schools){
			System.out.println(school.getDescription());
		}
	}
}
