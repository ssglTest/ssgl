package com.sdjz.initialize;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import org.junit.Before;
import org.junit.Test;

import com.sdjz.domain.Actor;
import com.sdjz.domain.Major;
import com.sdjz.domain.Role;
import com.sdjz.domain.School;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.domain.Teacher;
import com.sdjz.domain.Tutor;
import com.sdjz.domain.User;
import com.sdjz.help.CommonHelp;
import com.sdjz.initialize.domain.MajorWithFK;
import com.sdjz.initialize.domain.SecretaryWithFK;
import com.sdjz.initialize.domain.StudentWithFK;
import com.sdjz.initialize.domain.TeacherWithFK;
import com.sdjz.initialize.domain.TutorWithFK;
import com.sdjz.initialize.domain.UserWithFK;
import com.sdjz.initialize.excel.XlsDataSetBeanFactory;
import com.sdjz.service.TestBaseService;

/**
 *使用本程序之前需要将已经存在的数据库删除
 *
 */

public class DataToMySql extends TestBaseService{
	private String excelFile="excel/data.xls";
	private EntityManager entityManager;
	@Before
	public void init(){
		this.initialize();
	}
	
	@Test
	public void save() throws Exception{
		//先保存不需要关联的数据
		Class[] entityWithOutFKs={School.class,Role.class};
		for(Class clazz:entityWithOutFKs){
			this.saveEntity(clazz);
		}
		//保存存在外键的表
		this.saveMajor();
		this.saveSecretary();		
		this.saveTutor();
		this.saveTeacher();
		this.saveStudent();
		this.saveUser();
	}
	
	private void saveUser() throws Exception{
		//Role role=null;
		Actor actor=null;
		List<User> users=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile,"user",User.class);
		List<UserWithFK> userWithFKs=XlsDataSetBeanFactory.createBeans(this.getClass(), excelFile, "user", UserWithFK.class);
		for(User user:users){
			for(UserWithFK userWithFK:userWithFKs){
				if(user.getPassword().equals(userWithFK.getPassword())){
					//role=roleService.findById(userWithFK.getRoleId());
					actor=actorService.findById(userWithFK.getActorId());
					//user.setRole(role);
					user.setActor(actor);
					userService.save(user);
				}
			}
		}
		Integer index=0;
		List<User> savedusers=userService.findAll();
		for(User saveduser:savedusers){
			Integer roleId=userWithFKs.get(index++).getRoleId();
			saveduser.setRole(roleService.findById(roleId));
			userService.update(saveduser);
			userService.save(saveduser);
		}
		
	}
	
	private void saveStudent() throws Exception{
		Major major=null;
		School school=null;
		List<Teacher> teachers=null;
		Tutor tutor=null;
		List<Student> students=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile, "student",Student.class);
		List<StudentWithFK> studentWithFKs=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile,"student",StudentWithFK.class);
		for(Student student:students){
			for(StudentWithFK studentWithFK: studentWithFKs){
				if(student.getNo().equals(studentWithFK.getNo())){
					major=majorService.findById(studentWithFK.getMajorId());
					school=major.getSchool();
					teachers=teacherService.findAll();
					tutor=tutorService.findById(studentWithFK.getTutorId());
					student.setSchool(school);
					student.setMajor(major);
					student.setTutor(tutor);
					//student.setTeachers(teachers);
					studentService.save(student);
					
				}
			}
		}
	}
	//MajorWithFK与Major读取的是同一个excel表major，但是Major不能
	//不能读取schoolId这一关联字段
	private void saveMajor() throws Exception{
		School school=null;
		List<Major> majors=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile,"major",Major.class);
		List<MajorWithFK> majorWithFKs=XlsDataSetBeanFactory.createBeans(this.getClass(), excelFile,"major",MajorWithFK.class);
		for(Major major:majors){
			for(MajorWithFK majorWithFK:majorWithFKs){
				if(major.getNo().equals(majorWithFK.getNo())){
					school=schoolService.findById(majorWithFK.getSchoolId());
					major.setSchool(school);
					majorService.save(major);
				}
			}
		}
	}
	public void saveSecretary() throws Exception{
		School school=null;
		List<Secretary> secretaries=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile,"Secretary",Secretary.class);
		List<SecretaryWithFK> secretaryWithFKs=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile,"Secretary",SecretaryWithFK.class);
		for(Secretary secretary:secretaries){
			for(SecretaryWithFK secretaryWithFK:secretaryWithFKs){
				if(secretary.getNo().equals(secretaryWithFK.getNo())){
					school=schoolService.findById(secretaryWithFK.getSchoolId());
					secretary.setSchool(school);
					secretaryService.save(secretary);
				}
			}
		}
	}
	public void saveTeacher() throws Exception{
		Major major=null;
		School school=null;
		List<Teacher> teachers=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile, "teacher", Teacher.class);
		List<TeacherWithFK> teacherWithFKs=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile,"teacher",TeacherWithFK.class);
		for(Teacher teacher:teachers){
			for(TeacherWithFK teacherWithFK:teacherWithFKs){
				if(teacher.getNo().equals(teacherWithFK.getNo())){
					major=majorService.findById(teacherWithFK.getMajorId());
					school=schoolService.findById(teacherWithFK.getSchoolId());
					teacher.setMajor(major);
					teacher.setSchool(school);
					teacherService.save(teacher);
				}
			}
		}
	}
	private void saveTutor() throws Exception{
		Major major=null;
		School school=null;
		List<Tutor> tutors=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile, "tutor", Tutor.class);
		List<TutorWithFK> tutorWithFKs=XlsDataSetBeanFactory.createBeans(this.getClass(),excelFile,"tutor",TutorWithFK.class);
		for(Tutor tutor:tutors){
			for(TutorWithFK tutorWithFK:tutorWithFKs){
				if(tutor.getNo().equals(tutorWithFK.getNo())){
					major=majorService.findById(tutorWithFK.getMajorId());
					school=schoolService.findById(tutorWithFK.getSchoolId());
					tutor.setMajor(major);
					tutor.setSchool(school);
					tutorService.save(tutor);
				}
			}
		}
		
	}
	private void saveEntity(Class entity) throws Exception{
		for(Object t:listFormExcel(entity)){
			entityManager=entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(t);
			entityManager.getTransaction().commit();
			entityManager.close();
		}
	}
	private List<Class> listFormExcel(Class entity) throws Exception{
		//获取类名
		String className = getClassName(entity);
		String tableName=CommonHelp.initialToLowerCase(className);
		//将excel中的数据转换为对象
		return (List<Class>)XlsDataSetBeanFactory.createBeans(this.getClass(), excelFile, tableName, entity);
	}
	private List<Class> listFormExcel(Class entity,String tableName) throws Exception{
		//获取类名
		String className=getClassName(entity);
		//将excel表中的数据转换为对象
		return(List<Class>)XlsDataSetBeanFactory.createBeans(this.getClass(), excelFile, tableName, entity);
	}
	private String getClassName(Class entity){
		String className=entity.getName();
		//使用split分割字符串,通过.分割backage
		String regexStr="\\.";
		//获取最后一个值，split返回一个字符串数组
		className=className.split(regexStr)[className.split(regexStr).length-1];
		return className;
	}
	private void readList(Class entity) throws Exception{
		for(Object obj : listFormExcel(entity)){
			System.out.println(obj);
		}
	}

}
