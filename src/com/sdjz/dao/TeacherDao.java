package com.sdjz.dao;


import com.sdjz.domain.Teacher;
import com.sdjz.domain.Tutor;
import com.sdjz.jpaRepository.MyRepository;

public interface TeacherDao extends MyRepository<Teacher,Integer>{
	public Tutor findByNo(String no);

}
