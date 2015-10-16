package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.PaperTitleReply;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.PaperTitleReplyService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class PaperTitleReplyServiceTest {
	StudentService studentService;
	SecretaryService secretaryService;
	SchoolService schoolService;
	PaperTitleReplyService paperTitleReplyService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		paperTitleReplyService=(PaperTitleReplyService)ac.getBean("paperTitleReplyService");
		studentService = (StudentService)ac.getBean("studentService");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
	
	}
	@Test
	public void save(){
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<PaperTitleReply> paperTitleApplies=new ArrayList<PaperTitleReply>();
		paperTitleApplies.add(new PaperTitleReply("http://www.456","论文题目答辩"));
		paperTitleApplies.add(new PaperTitleReply("wwww","答辩"));
		for(PaperTitleReply paperTitleReply:paperTitleApplies){
		paperTitleReply.setSecretary(secretary);
		paperTitleReply.setSchool(school);
		paperTitleReplyService.save(paperTitleReply);
		}
	}

}
