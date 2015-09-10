package com.sdjz.testService;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Teacher;
import com.sdjz.service.SchoolService;
import com.sdjz.service.TeacherService;

public class TeacherServiceTest {
	TeacherService teacherService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		teacherService=(TeacherService)ac.getBean("teacherService");
	}
	@Test
	public void save(){
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers.add(new Teacher("0101","0101"));
		teacherService.saveTeachers(teachers);
		}
	@Test
	public void findById(){
		Teacher teacher= teacherService.findById(32768);
		System.out.println("teacher NO" +teacher.getNo());
	}
	@Test
	public void findByNo(){
		Teacher teacher=teacherService.findByNo("0101");
		System.out.println("teacher Name"+teacher.getName());
	}

}
