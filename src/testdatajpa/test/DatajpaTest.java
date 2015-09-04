package testdatajpa.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import testdatajpa.domain.Tutor;
import testdatajpa.domain.User;
import testdatajpa.service.RoleService;
import testdatajpa.service.TutorService;
import testdatajpa.service.UserService;

public class DatajpaTest {
	DataSource dataSource;
	UserService userService;
	RoleService roleService;
	TutorService tutorService;
	
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource =ac.getBean(DataSource.class);
		userService=(UserService)ac.getBean("userService");
		roleService=(RoleService)ac.getBean("roleService");
		tutorService=(TutorService)ac.getBean("tutorService");
	}
	@Test
	public void testDataSource() throws SQLException{
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void save(){
//		User user =new User("201302","201302");
//		userService.saveUser(user);
		Tutor tutor=new Tutor();
		tutor.setName("001");
		tutor.setNo("001");
		tutorService.saveTutor(tutor);
	}

}
