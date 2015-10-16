package com.sdjz.serviceTest;

import java.util.ArrayList;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.School;
import com.sdjz.domain.SciencePaperCheck;
import com.sdjz.domain.Secretary;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SciencePaperCheckService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;




public class SciencePaperCheckServiceTest {
	StudentService studentService;
	SecretaryService secretaryService;
	SchoolService schoolService;
	SciencePaperCheckService sciencePaperCheckService;

	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		sciencePaperCheckService=(SciencePaperCheckService)ac.getBean("sciencePaperCheckService");
		studentService = (StudentService)ac.getBean("studentService");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
	
	}
	@Test
	public void save(){
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<SciencePaperCheck> sciencePaperChecks=new ArrayList<SciencePaperCheck>();
		sciencePaperChecks.add(new SciencePaperCheck("123","456"));
		sciencePaperChecks.add(new SciencePaperCheck("123111","456222"));
		for(SciencePaperCheck sciencePaperCheck:sciencePaperChecks){
			sciencePaperCheck.setSecretary(secretary);
			sciencePaperCheck.setSchool(school);
			sciencePaperCheckService.save(sciencePaperCheck);
		}
		}
	

}
