package com.sdjz.serviceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Tutor;
import com.sdjz.service.TutorService;

public class TutorServiceTest {
	TutorService tutorService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		tutorService=(TutorService)ac.getBean("tutorService");
		
	}
	
	@Test
	public void findAll(){
		List<Tutor> tutors=tutorService.findAll();
		for(Tutor tutor: tutors){
			System.out.println(tutor.getName());
		}
	}

}
