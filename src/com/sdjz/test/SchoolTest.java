package com.sdjz.test;

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

public class SchoolTest {
	SchoolService schoolService;
	TutorService tutorService;
	StudentService studentService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		schoolService=(SchoolService)ac.getBean("shoolService");
		tutorService=(TutorService)ac.getBean("tutorService");
		studentService=(StudentService)ac.getBean("studentService");
		
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
	@Test
	public void findTutor(){
		School school=schoolService.findById(1);
		Set<Tutor> tutors=school.getTutors();
		for(Tutor tutor:tutors){	
		System.out.println("Tutor No ========"+tutor.getNo());
		}
	}
	
}
