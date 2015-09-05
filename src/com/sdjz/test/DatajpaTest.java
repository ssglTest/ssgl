package com.sdjz.test;

import java.sql.SQLException;

import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.dao.TutorDao;
import com.sdjz.domain.Actor;
import com.sdjz.domain.Role;
import com.sdjz.domain.Student;
import com.sdjz.domain.Tutor;
import com.sdjz.domain.User;
import com.sdjz.service.RoleService;
import com.sdjz.service.StudentService;
import com.sdjz.service.TutorService;
import com.sdjz.service.UserService;

public class DatajpaTest {
	DataSource dataSource;
	UserService userService;
	RoleService roleService;
	TutorService tutorService;
	StudentService studentService;
	RoleService schoolService;
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource =ac.getBean(DataSource.class);
		userService=(UserService)ac.getBean("userService");
		roleService=(RoleService)ac.getBean("roleService");
		tutorService=(TutorService)ac.getBean("tutorService");
		studentService=(StudentService)ac.getBean("studentService");
		//schoolService=(RoleService)ac.getBean("schoolService");
	}
	@Test
	public void testDataSource() throws SQLException{
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void save(){
		
		Tutor tutor=new Tutor("001","001");
		
		Student student =new Student("201301","aa");
		student.setTutor(tutor);
		
	
		User user =new User(tutor.getNo(),tutor.getNo());
		user.setActor(tutor);
		tutor.setUser(user);//鐠佸墽鐤唗utor_id鐏忓敆utor娑撳窓ser閸忓疇浠�
		userService.saveUser(user);
			
		User userStudent =new User(student.getNo(),student.getNo());
		userStudent.setActor(student);
		student.setUser(userStudent);
		userService.saveUser(userStudent);
		Role role1=new Role("研究生");
		roleService.saveRole(role1);
		Role role=new Role("研究生导师");
	    roleService.saveRole(role);
		
	}
	@Test
	public void saveRole(){
		
		System.out.println("Sudent    "+studentService.findByNo("201301"));
		
	}

	

}
