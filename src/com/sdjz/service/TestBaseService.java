package com.sdjz.service;

import javax.persistence.EntityManagerFactory;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestBaseService{
	protected ActorService actorService;
	protected SchoolService schoolService;
	protected RoleService roleService;
	protected ResourceService resourceService;
	protected MajorService majorService;
	protected SecretaryService secretaryService;
	protected TeacherService teacherService;
	protected TutorService tutorService;
	protected StudentService studentService;
	protected UserService userService;
	protected PaperTitleApplyService paperTitleApplyService;
	protected EntityManagerFactory entityManagerFactory;
	
	public TestBaseService(){}
	public void initialize(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		actorService=(ActorService)ac.getBean("actorService");
		schoolService=(SchoolService)ac.getBean("schoolService");
		roleService=(RoleService)ac.getBean("roleService");
		resourceService=(ResourceService)ac.getBean("resourceService");
		majorService=(MajorService)ac.getBean("majorService");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		teacherService=(TeacherService)ac.getBean("teacherService");
		tutorService=(TutorService)ac.getBean("tutorService");
		studentService=(StudentService)ac.getBean("studentService");
		userService=(UserService)ac.getBean("userService");
		
		paperTitleApplyService=(PaperTitleApplyService)ac.getBean("paperTitleApplyService");
		entityManagerFactory=(EntityManagerFactory)ac.getBean("entityManagerFactory");
	}

}
