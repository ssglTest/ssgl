package com.sdjz.serviceTest;

import java.util.ArrayList;
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
import com.sdjz.domain.Teacher;
import com.sdjz.domain.Tutor;
import com.sdjz.domain.User;
import com.sdjz.service.MajorService;
import com.sdjz.service.RoleService;
import com.sdjz.service.SchoolService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;
import com.sdjz.service.TeacherService;
import com.sdjz.service.TutorService;
import com.sdjz.service.UserService;

public class SaveTest {
	DataSource dataSource;
	UserService userService;
	RoleService roleService;
	TutorService tutorService;
	StudentService studentService;
	SchoolService schoolService;
	SecretaryService secretaryService;
	MajorService majorService;
	TeacherService teacherService;
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
		teacherService=(TeacherService)ac.getBean("teacherService");
	}
	@Test
	public void testSave(){
		List<Role> roles=new ArrayList<Role>();
		roles.add(new Role("student"));
		roles.add(new Role("tutor"));
		roles.add(new Role("teacher"));
		roles.add(new Role("secretary"));
		roleService.saves(roles);
		
		List<School> schools=new ArrayList<School>();
		schools.add(new School("AA"));
		schools.add(new School("BB"));
		schoolService.saves(schools);
		
		School school=schoolService.findById(1);
		Major major=new Major("信管");
		major.setSchool(school);
		majorService.save(major);
		Major major1=new Major("造价");
		major1.setSchool(school);
		majorService.save(major1);
		
		Major hasSavedMajor = majorService.findById(1);
		
		Tutor tutor =new Tutor("001","tutor");
		tutor.setSchool(school);
		tutor.setMajor(hasSavedMajor);
		
		List<Teacher> teachers = new ArrayList<Teacher>();
		teachers.add(new Teacher("111","teacher"));
		for(Teacher teacher:teachers){
		teacher.setSchool(school);
		teacher.setMajor(hasSavedMajor);
		}
		
		Student student= new Student("201301","student");
		student.setSchool(school);
		
		Secretary secretary = new Secretary("1001","secretary");
		secretary.setSchool(school);
		
		Role tutorRole=roleService.findByDescription("tutor");
		
		User userTutor = new User(tutor.getNo(),tutor.getNo());
		userTutor.setActor(tutor);
		tutor.setUser(userTutor);
		userTutor.setRole(tutorRole);
		userService.save(userTutor);
		
		Role teacherRole=roleService.findByDescription("teacher");
				
		User userTeacher = new User(teachers.get(0).getNo(),teachers.get(0).getNo());
		userTeacher.setActor(teachers.get(0));
		teachers.get(0).setUser(userTeacher);
		userTeacher.setRole(teacherRole);
		userService.save(userTeacher);
		
		Tutor hasSavedTutor =tutorService.findById(1);
		List<Teacher> hasSavedTeachers=teacherService.findAll();
		Role studentRole=roleService.findByDescription("student");
		
		User userStudent = new User(student.getNo(),student.getNo());
		userStudent.setActor(student);
		student.setUser(userStudent);
		student.setTutor(hasSavedTutor);
		student.setTeachers(hasSavedTeachers);
		userStudent.setRole(studentRole);
		userService.save(userStudent);
		
		Role secretaryRole=roleService.findByDescription("secretary");
		
		User userSecretary = new User(secretary.getNo(),secretary.getNo());
		userSecretary.setActor(secretary);
		secretary.setUser(userSecretary);
		userSecretary.setRole(secretaryRole);
		userService.save(userSecretary);
		
		
	}


}
