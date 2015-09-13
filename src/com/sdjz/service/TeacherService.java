package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.TutorDao;
import com.sdjz.dao.TeacherDao;
import com.sdjz.domain.Teacher;
import com.sdjz.domain.Tutor;
import com.sdjz.jpaRepository.MyRepository;

@Service("teacherService")
public class TeacherService extends BasicService<Teacher,Integer>{
	private TeacherDao teacherDao;
	
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Teacher, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.teacherDao=(TeacherDao)basicDao;
	}
	public Tutor findByNo(String no){
		return teacherDao.findByNo(no);
	}
	
	
}
