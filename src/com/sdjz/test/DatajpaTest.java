package com.sdjz.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.Major;
import com.sdjz.domain.Role;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.domain.Tutor;
import com.sdjz.domain.User;
import com.sdjz.service.MajorService;
import com.sdjz.service.RoleService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;
import com.sdjz.service.TutorService;
import com.sdjz.service.UserService;



public class DatajpaTest {
	DataSource dataSource;
	UserService userService;
	RoleService roleService;
	TutorService tutorService;
	StudentService studentService;
	SchoolService schoolService;
	SecretaryService secretaryService;
	MajorService majorService;

	
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource =ac.getBean(DataSource.class);
		userService=(UserService)ac.getBean("userService");
		roleService=(RoleService)ac.getBean("roleService");
		tutorService=(TutorService)ac.getBean("tutorService");
		studentService=(StudentService)ac.getBean("studentService");
		schoolService=(SchoolService)ac.getBean("shoolService");
		secretaryService=(SecretaryService)ac.getBean("secretaryService");
		majorService=(MajorService)ac.getBean("majorService");
	}
	@Test
	public void testDataSource() throws SQLException{
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void save(){
		List<Role> roles=roleService.findAll();
		School school=schoolService.findById(1);
		Major major=majorService.findById(1);
		
		Tutor tutor=new Tutor("001","001");
		tutor.setSchool(school);
		tutor.setMajor(major);
		
		Student student =new Student("201301","aa");
		student.setTutor(tutor);
		student.setSchool(school);
		
		Secretary secretary=new Secretary("1001","1001");
		secretary.setSchool(school);
	
		User userTutor =new User(tutor.getNo(),tutor.getNo());
		userTutor.setActor(tutor);
		tutor.setUser(userTutor);
		userTutor.setRoles(roles);
		userService.saveUser(userTutor);
			
		User userStudent =new User(student.getNo(),student.getNo());
		userStudent.setActor(student);
		student.setUser(userStudent);
		userStudent.setRoles(roles);
		userService.saveUser(userStudent);
		
		User userSecretary =new User(secretary.getNo(),secretary.getNo());
		userSecretary.setActor(secretary);
		secretary.setUser(userSecretary);
		userSecretary.setRoles(roles);
		userService.saveUser(userSecretary);
		
		
	}
	@Test
	public void findRole(){
		User user=userService.findById(1);
		List<Role> roles=user.getRoles();
		for(Role role:roles){
			System.out.println(role.getDescription());
		}	
		
	}
	@Test
	public void FindTutor(){
		User user=userService.findById(1);
		System.out.println(((Tutor)user.getActor()).getNo());
	}

	

}
