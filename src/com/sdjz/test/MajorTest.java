package com.sdjz.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Major;
import com.sdjz.service.MajorService;


public class MajorTest {
	MajorService majorService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		majorService=(MajorService)ac.getBean("majorService");
		
	}
	@Test
	public void save(){
		Major major=new Major("�Ź�");
		majorService.saveMajor(major);
		Major major1=new Major("���");
		majorService.saveMajor(major1);
	}

}
