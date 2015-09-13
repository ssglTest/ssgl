package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.StudentDao;
import com.sdjz.domain.Student;
import com.sdjz.jpaRepository.MyRepository;

@Service("studentService")
public class StudentService extends BasicService<Student,Integer> {
	private StudentDao studentDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Student, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.studentDao=(StudentDao)basicDao;
	}
	public Student findByNo(String no){
		return studentDao.findByNo(no);
	}
}
