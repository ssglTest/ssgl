package com.sdjz.dao;


import com.sdjz.domain.Student;
import com.sdjz.jpaRepository.MyRepository;

public interface StudentDao extends MyRepository<Student,Integer> {
	public Student findByNo(String no);

}
