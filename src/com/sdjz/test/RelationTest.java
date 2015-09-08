package com.sdjz.test;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Major;
import com.sdjz.domain.School;
import com.sdjz.service.MajorService;
import com.sdjz.service.SchoolService;

public class RelationTest {
	MajorService majorService;
	SchoolService schoolService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		majorService=(MajorService)ac.getBean("majorService");
		schoolService=(SchoolService)ac.getBean("shoolService");		
	}
	@Test
	public void major_school(){
		School school=schoolService.findById(2);
		List<Major> majors= majorService.findAll();
		for(Major major:majors){
			major.setSchool(school);
		}
	}

}
