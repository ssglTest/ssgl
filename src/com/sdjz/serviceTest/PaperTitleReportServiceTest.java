package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.PaperTitleReport;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.service.PaperTitleReportService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class PaperTitleReportServiceTest {
	StudentService studentService;
	SecretaryService secretaryService;
	SchoolService schoolService;
	PaperTitleReportService paperTitleReportService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		paperTitleReportService=(PaperTitleReportService)ac.getBean("paperTitleReportService");
		studentService = (StudentService)ac.getBean("studentService");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
	
	}
	@Test
	public void save(){
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<PaperTitleReport> paperTitleApplies=new ArrayList<PaperTitleReport>();
		paperTitleApplies.add(new PaperTitleReport("http://www.456","论文题目答辩"));
		paperTitleApplies.add(new PaperTitleReport("wwww","答辩"));
		for(PaperTitleReport paperTitleReport:paperTitleApplies){
		paperTitleReport.setSecretary(secretary);
		paperTitleReport.setSchool(school);
		paperTitleReportService.save(paperTitleReport);
		}
	}

}
