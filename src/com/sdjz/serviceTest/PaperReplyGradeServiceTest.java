package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.PaperReplyGrade;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.PaperReplyGradeService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class PaperReplyGradeServiceTest {
	SecretaryService secretaryService;
	SchoolService schoolService;
	StudentService studentService;
	PaperReplyGradeService paperReplyGradeService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
		studentService=(StudentService)ac.getBean("studentService");
		paperReplyGradeService=(PaperReplyGradeService)ac.getBean("paperReplyGradeService");
	}
	@Test
	public void save(){
		/*Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);*/
		Student student=studentService.findById(12);
		PaperReplyGrade paperReplyGrade=new PaperReplyGrade("123");
		paperReplyGrade.setStudent(student);
		paperReplyGradeService.save(paperReplyGrade);
		
	}
	@Test
	public void saveStudent(){
		
	}


}
