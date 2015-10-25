package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.PaperReplyNotifiCation;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.PaperReplyNotifiCationService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class PaperReplyNotifiCationServiceTest {
	SecretaryService secretaryService;
	SchoolService schoolService;
	StudentService studentService;
	PaperReplyNotifiCationService paperReplyNotifiCationService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
		studentService=(StudentService)ac.getBean("studentService");
		paperReplyNotifiCationService=(PaperReplyNotifiCationService)ac.getBean("paperReplyNotifiCationService");
	}
	@Test
	public void save(){
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<PaperReplyNotifiCation> paperReplyNotifications=new ArrayList<PaperReplyNotifiCation>();
		paperReplyNotifications.add(new PaperReplyNotifiCation("http://www.123","论文题目申请"));
		paperReplyNotifications.add(new PaperReplyNotifiCation("wwww","论文"));
		for(PaperReplyNotifiCation paperReplyNotifiCation:paperReplyNotifications){
		paperReplyNotifiCation.setSecretary(secretary);
		paperReplyNotifiCation.setSchool(school);
		paperReplyNotifiCationService.save(paperReplyNotifiCation);
		}
	}
	@Test
	public void saveStudent(){
		Student student=studentService.findById(12);
		PaperReplyNotifiCation paperReplyNotifiCation=paperReplyNotifiCationService.findById(1);
		paperReplyNotifiCation.setStudent(student);
		paperReplyNotifiCationService.update(paperReplyNotifiCation);
		paperReplyNotifiCationService.save(paperReplyNotifiCation);
	}


}
