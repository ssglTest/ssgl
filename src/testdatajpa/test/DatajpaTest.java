package testdatajpa.test;

import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import testdatajpa.domain.User;
import testdatajpa.service.UserService;

public class DatajpaTest {
	DataSource dataSource;
	UserService userService;
	@Before
	public void init(){
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		dataSource =ac.getBean(DataSource.class);
		userService=(UserService)ac.getBean("userService");
	}
	@Test
	public void testDataSource() throws SQLException{
		System.out.println(dataSource.getConnection());
	}
	@Test
	public void save(){
		User user = new User("杨洋",22);
		userService.save(user);
	}
//	@Test
//	public void criteria(){
//		List<User> users=userService.criteria("鏉�%");
//		for(User user:users){
//			System.out.println(user.getName());
//		}
//	}

}
