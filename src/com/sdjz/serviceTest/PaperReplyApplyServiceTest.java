package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.PaperReplyApply;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.PaperReplyApplyService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class PaperReplyApplyServiceTest {
	SecretaryService secretaryService;
	SchoolService schoolService;
	StudentService studentService;
	PaperReplyApplyService paperReplyApplyService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
		studentService=(StudentService)ac.getBean("studentService");
		paperReplyApplyService=(PaperReplyApplyService)ac.getBean("paperReplyApplyService");
	}
	@Test
	public void save(){
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<PaperReplyApply> paperReplyApplies=new ArrayList<PaperReplyApply>();
		paperReplyApplies.add(new PaperReplyApply("http://www.123","论文题目申请"));
		paperReplyApplies.add(new PaperReplyApply("wwww","论文"));
		for(PaperReplyApply paperReplyApply:paperReplyApplies){
		paperReplyApply.setSecretary(secretary);
		paperReplyApply.setSchool(school);
		paperReplyApplyService.save(paperReplyApply);
		}
	}
	@Test
	public void saveStudent(){
		Student student=studentService.findById(12);
		PaperReplyApply paperReplyApply=paperReplyApplyService.findById(1);
		paperReplyApply.setStudent(student);
		paperReplyApplyService.update(paperReplyApply);
		paperReplyApplyService.save(paperReplyApply);
	}

}
