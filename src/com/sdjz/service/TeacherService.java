package com.sdjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.TeacherDao;
import com.sdjz.domain.Teacher;
@Service("teacherService")
public class TeacherService {
	@Autowired
	TeacherDao teacherDao;
	
	public TeacherService(){}
	
	public void saveTeacher(Teacher teacher){
		teacherDao.save(teacher);
	}
	public void saveTeachers(List<Teacher> teachers){
		for(Teacher teacher:teachers){
			teacherDao.save(teacher);
		}
	}
	public Teacher findByNo(String no){
		return teacherDao.findByNo(no);
	}
	public Teacher findById(Integer id){
		return teacherDao.findOne(id);
	}
	public List<Teacher> findAll(){
		return teacherDao.findAll();
	}

}
