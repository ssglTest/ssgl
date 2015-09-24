package com.sdjz.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.PaperTitleApply;
import com.sdjz.domain.Student;
import com.sdjz.service.PaperTitleApplyService;
import com.sdjz.service.StudentService;

public class PaperTitleApplyServiceTest {
	PaperTitleApplyService paperTitleApplyService;
	StudentService studentService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		paperTitleApplyService=(PaperTitleApplyService)ac.getBean("paperTitleApplyService");
		studentService = (StudentService)ac.getBean("studentService");
	}
	@Test
	public void save(){
		Student student=studentService.findById(3);
		PaperTitleApply paperTitleApply=new PaperTitleApply("http://www.123","论文题目申请");
		paperTitleApply.setStudent(student);
		paperTitleApplyService.save(paperTitleApply);
		
	}
	@Test
	public void findStudent(){
		PaperTitleApply paperTitleApply=paperTitleApplyService.findById(1);
		System.out.println("student name========"+paperTitleApply.getStudent().getName());
	}

}
