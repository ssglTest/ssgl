package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sdjz.domain.Student;

public interface StudentDao extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student> {
	public Student findByNo(String no);

}
