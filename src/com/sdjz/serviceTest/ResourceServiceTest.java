package com.sdjz.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Resource;
import com.sdjz.service.ResourceService;

public class ResourceServiceTest {
	ResourceService resourceService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		resourceService=(ResourceService)ac.getBean("resourceService");
	}
	@Test
	public void save(){
		
	}

}
