package com.sdjz.serviceTest;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import com.sdjz.domain.PaperTitleApply;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.PaperTitleApplyService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class PaperTitleApplyServiceTest {
	PaperTitleApplyService paperTitleApplyService;
	StudentService studentService;
	SecretaryService secretaryService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		paperTitleApplyService=(PaperTitleApplyService)ac.getBean("paperTitleApplyService");
		studentService = (StudentService)ac.getBean("studentService");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
	}
	@Test
	public void save(){
		Student student=studentService.findById(3);
		Secretary secretary=secretaryService.findById(4);
		PaperTitleApply paperTitleApply=new PaperTitleApply("http://www.123","论文题目申请");
		paperTitleApply.setStudent(student);
		paperTitleApply.setSecretary(secretary);
		paperTitleApplyService.save(paperTitleApply);
		
	}
	@Test
	public void findStudent(){
		PaperTitleApply paperTitleApply=paperTitleApplyService.findById(1);
		System.out.println("student name========"+paperTitleApply.getStudent().getName());
	}
	@Test
	public void pageQuery(){
		Page<PaperTitleApply> result = paperTitleApplyService.pageQueryBySecretary(4);
		for(PaperTitleApply paper:result){
			System.out.println(paper.getUrl());
		}
	}

}
