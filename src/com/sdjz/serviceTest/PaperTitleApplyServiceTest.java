package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.domain.Page;

import com.sdjz.domain.PaperTitleApply;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.PaperTitleApplyService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class PaperTitleApplyServiceTest {
	PaperTitleApplyService paperTitleApplyService;
	SecretaryService secretaryService;
	SchoolService schoolService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		paperTitleApplyService=(PaperTitleApplyService)ac.getBean("paperTitleApplyService");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
	}
	@Test
	public void save(){
		
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<PaperTitleApply> paperTitleApplies=new ArrayList<PaperTitleApply>();
		paperTitleApplies.add(new PaperTitleApply("http://www.123","论文题目申请"));
		paperTitleApplies.add(new PaperTitleApply("wwww","论文"));
		for(PaperTitleApply paperTitleApply:paperTitleApplies){
		paperTitleApply.setSecretary(secretary);
		paperTitleApply.setSchool(school);
		paperTitleApplyService.save(paperTitleApply);
		}
		
	}
	@Test
	public void find(){
		School school=schoolService.findById(1);
		List<PaperTitleApply> paperTitleApplies=school.getPaperTitleApplies();
		System.out.println(paperTitleApplies.toString());
	}
	@Test
	public void pageQuery(){
		Page<PaperTitleApply> result = paperTitleApplyService.pageQueryBySecretary(4);
		for(PaperTitleApply paper:result){
			System.out.println(paper.getUrl());
		}
	}

}
