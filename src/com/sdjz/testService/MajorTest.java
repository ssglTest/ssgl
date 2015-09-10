package com.sdjz.testService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Major;
import com.sdjz.domain.School;
import com.sdjz.service.MajorService;
import com.sdjz.service.SchoolService;


public class MajorTest {
	MajorService majorService;
	SchoolService schoolService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		majorService=(MajorService)ac.getBean("majorService");
		schoolService=(SchoolService)ac.getBean("schoolService");
		
	}
	@Test
	public void save(){
		School school=schoolService.findById(1);
		Major major=new Major("信管");
		major.setSchool(school);
		majorService.saveMajor(major);
		Major major1=new Major("造价");
		major1.setSchool(school);
		majorService.saveMajor(major1);
	
	}

}
