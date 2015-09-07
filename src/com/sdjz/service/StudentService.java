package com.sdjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.StudentDao;
import com.sdjz.domain.Student;

@Service("studentService")
public class StudentService {
	@Autowired
	StudentDao studentDao;
	public StudentService(){}
	
	public void saveStudent(Student student){
		studentDao.save(student);
	}
	public void saveStudents(List<Student> students){
		for(Student student:students){
			studentDao.save(student);
		}
	}
	public Student findByNo(String no){
		return studentDao.findByNo(no);
	}
	public Student findById(Integer id){
		return studentDao.findOne(id);
	}
	public List<Student> findAll(){
		return studentDao.findAll();
	}


}
