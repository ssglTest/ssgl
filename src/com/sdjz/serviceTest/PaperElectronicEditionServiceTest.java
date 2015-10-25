package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.PaperElectronicEdition;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.PaperElectronicEditionService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class PaperElectronicEditionServiceTest {
	SecretaryService secretaryService;
	SchoolService schoolService;
	StudentService studentService;
	PaperElectronicEditionService paperElectronicEditionService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
		studentService=(StudentService)ac.getBean("studentService");
		paperElectronicEditionService=(PaperElectronicEditionService)ac.getBean("paperElectronicEditionService");
	}
	@Test
	public void save(){
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<PaperElectronicEdition> paperElectronicEditions=new ArrayList<PaperElectronicEdition>();
		paperElectronicEditions.add(new PaperElectronicEdition("http://www.123","论文题目申请"));
		paperElectronicEditions.add(new PaperElectronicEdition("wwww","论文"));
		for(PaperElectronicEdition paperElectronicEdition:paperElectronicEditions){
		paperElectronicEdition.setSecretary(secretary);
		paperElectronicEdition.setSchool(school);
		paperElectronicEditionService.save(paperElectronicEdition);
		}
	}
	@Test
	public void saveStudent(){
		Student student=studentService.findById(12);
		PaperElectronicEdition PaperElectronicEdition=paperElectronicEditionService.findById(1);
		PaperElectronicEdition.setStudent(student);
		paperElectronicEditionService.update(PaperElectronicEdition);
		paperElectronicEditionService.save(PaperElectronicEdition);
	}

}
