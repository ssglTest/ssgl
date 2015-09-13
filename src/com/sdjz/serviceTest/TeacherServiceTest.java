package com.sdjz.serviceTest;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Teacher;
import com.sdjz.domain.Tutor;
import com.sdjz.service.TutorService;
import com.sdjz.service.TeacherService;

public class TeacherServiceTest {
	TeacherService teacherService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		teacherService=(TeacherService)ac.getBean("teacherService");
		
	}
	
	@Test
	public void findAll(){
		List<Teacher> teachers=teacherService.findAll();
		for(Teacher teacher: teachers){
			System.out.println(teacher.getName());
		}
	}

}
