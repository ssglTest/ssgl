package com.sdjz.serviceTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.MasterDegreeAudit;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.service.MasterDegreeAuditService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

public class MasterDegreeAuditServiceTest {
	SecretaryService secretaryService;
	SchoolService schoolService;
	StudentService studentService;
	MasterDegreeAuditService masterDegreeAuditService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		schoolService=(SchoolService)ac.getBean("schoolService");
		studentService=(StudentService)ac.getBean("studentService");
		masterDegreeAuditService=(MasterDegreeAuditService)ac.getBean("masterDegreeAuditService");
	}
	@Test
	public void save(){
		Secretary secretary=secretaryService.findById(1);
		School school=schoolService.findById(1);
		List<MasterDegreeAudit> masterDegreeAudits=new ArrayList<MasterDegreeAudit>();
		masterDegreeAudits.add(new MasterDegreeAudit("http://www.123","论文题目申请"));
		masterDegreeAudits.add(new MasterDegreeAudit("wwww","论文"));
		for(MasterDegreeAudit masterDegreeAudit:masterDegreeAudits){
		masterDegreeAudit.setSecretary(secretary);
		masterDegreeAudit.setSchool(school);
		masterDegreeAuditService.save(masterDegreeAudit);
		}
	}
	@Test
	public void saveStudent(){
		Student student=studentService.findById(12);
		MasterDegreeAudit MasterDegreeAudit=masterDegreeAuditService.findById(1);
		MasterDegreeAudit.setStudent(student);
		masterDegreeAuditService.update(MasterDegreeAudit);
		masterDegreeAuditService.save(MasterDegreeAudit);
	}

}
