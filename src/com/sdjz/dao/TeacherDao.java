package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdjz.domain.Teacher;

public interface TeacherDao extends JpaRepository<Teacher,Integer>{
	public Teacher findByNo(String  no);

}
