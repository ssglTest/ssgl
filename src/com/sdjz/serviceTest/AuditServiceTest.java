package com.sdjz.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Audit;
import com.sdjz.service.AuditService;



public class AuditServiceTest {
	AuditService auditService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		auditService=(AuditService)ac.getBean("auditService");
	}
	@Test
	public void save(){
		Audit audit=new Audit("通过","不通过");
		auditService.save(audit);
	}

}
