package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.MidtermCheck;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.MidtermCheckService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class MidtermCheckServiceTest {
	SecretaryService secretaryService;
	SchoolService schoolService;
	StudentService studentService;
	MidtermCheckService midtermCheckService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
		studentService=(StudentService)ac.getBean("studentService");
		midtermCheckService=(MidtermCheckService)ac.getBean("midtermCheckService");
	}
	@Test
	public void save(){
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<MidtermCheck> midtermChecks=new ArrayList<MidtermCheck>();
		midtermChecks.add(new MidtermCheck("http://www.123","论文题目申请"));
		midtermChecks.add(new MidtermCheck("wwww","论文"));
		for(MidtermCheck MidtermCheck:midtermChecks){
		MidtermCheck.setSecretary(secretary);
		MidtermCheck.setSchool(school);
		midtermCheckService.save(MidtermCheck);
		}
	}
	@Test
	public void saveStudent(){
		Student student=studentService.findById(12);
		MidtermCheck midtermCheck=midtermCheckService.findById(1);
		midtermCheck.setStudent(student);
		midtermCheckService.update(midtermCheck);
		midtermCheckService.save(midtermCheck);
	}

}
