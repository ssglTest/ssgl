package com.sdjz.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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

	
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource =ac.getBean(DataSource.class);
		userService=(UserService)ac.getBean("userService");
		roleService=(RoleService)ac.getBean("roleService");
		tutorService=(TutorService)ac.getBean("tutorService");
		studentService=(StudentService)ac.getBean("studentService");
	}
	@Test
	public void testDataSource() throws SQLException{
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void save(){
		
		Role role1=new Role("student");
		//role1.setUsers(users);
		roleService.saveRole(role1);
		Role role=new Role("student_Teacher");
		//role.setUsers(users);
	    roleService.saveRole(role);
	    List<Role> roles =new ArrayList<Role>();
	    roles.add(role);
	    roles.add(role1);
	    
		Tutor tutor=new Tutor("001","001");
		
		Student student =new Student("201301","aa");
		student.setTutor(tutor);
	
		User user =new User(tutor.getNo(),tutor.getNo());
		user.setActor(tutor);
		tutor.setUser(user);
		user.setRoles(roles);
		userService.saveUser(user);
			
		User userStudent =new User(student.getNo(),student.getNo());
		userStudent.setActor(student);
		student.setUser(userStudent);
		userStudent.setRoles(roles);
		userService.saveUser(userStudent);
		List<User> users =new ArrayList<User>();
		users.add(user);
		users.add(userStudent);
		
		
	}
	@Test
	public void findRole(){
		User user=userService.findById(1);
		List<Role> roles=user.getRoles();
		for(Role role:roles){
			System.out.println(role.getDescription());
		}
		
		
	}

	

}
