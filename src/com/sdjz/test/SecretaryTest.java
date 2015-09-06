package com.sdjz.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Secretary;
import com.sdjz.service.SecretaryService;

public class SecretaryTest {
	SecretaryService secretaryService;

	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
	}
	@Test
	public void save(){
		Secretary secretary =new Secretary("1001","1001");
		secretaryService.saveSecretary(secretary);
	}

}
