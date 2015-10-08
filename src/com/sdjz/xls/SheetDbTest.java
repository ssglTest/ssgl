package com.sdjz.xls;

import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sdjz.domain.User;
import com.sdjz.exception.DatabaseException;
import com.sdjz.service.UserService;



public class SheetDbTest {
	SheetDb excelDb;
	UserService userService;
	@Before
	public void init() throws Exception{
		ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
		 excelDb=new SheetDb(new File("E://user.xls"));
		 userService=(UserService)ac.getBean("userService");
	}
	@Test
	public void test() throws Exception{
		excelDb.print();
		System.out.println(excelDb.getCell(2,"role"));
	}
	@Test
	public void saveToDatabase() throws FileNotFoundException, IOException, DatabaseException{
		while(excelDb.next()){
			System.out.print(excelDb.getCell("password"));
			System.out.print(",");
			System.out.print(excelDb.getCell("userName"));
			System.out.print(",");
			System.out.print(excelDb.getCell("role"));
			//User user=new User(excelDb.getCell("password"),excelDb.getCell("userName"),excelDb.getCell("role"));
			//userService.save(user);
		}
		
		
		
		
	}
	
	
	

}
