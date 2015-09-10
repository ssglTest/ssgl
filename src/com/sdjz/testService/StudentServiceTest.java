package com.sdjz.testService;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Student;
import com.sdjz.service.StudentService;

public class StudentServiceTest {
	StudentService studentService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		studentService =(StudentService)ac.getBean("studentService");
	}
	@Test
	public void updateById(){
		Student student =studentService.findById(3);
		student.setName("样样");
		//studentService.updateById(3);
	}

}
