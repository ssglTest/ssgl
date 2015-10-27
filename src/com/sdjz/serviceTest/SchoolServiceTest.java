package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.School;
import com.sdjz.domain.Tutor;
import com.sdjz.service.SchoolService;
import com.sdjz.service.StudentService;
import com.sdjz.service.TutorService;

public class SchoolServiceTest {
	SchoolService schoolService;
	TutorService tutorService;
	StudentService studentService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		schoolService=(SchoolService)ac.getBean("schoolService");
		tutorService=(TutorService)ac.getBean("tutorService");
		studentService=(StudentService)ac.getBean("studentService");
		
	}
	@Test
	public void save(){
		List<School> schools=new ArrayList<School>();
		schools.add(new School("AA"));
		schools.add(new School("BB"));
		schoolService.saves(schools);
	}
	@Test
	public void getResult(){
		School school=schoolService.getResult(School.class,"description","123");		
			System.out.println(school.getDescription());		
	}
	@Test
	public void likeQuery(){
		List<School> schools=schoolService.likeQuery(School.class,"description"," ");
		for(School school:schools){
			System.out.println(school.getDescription());
		}
	}
}
