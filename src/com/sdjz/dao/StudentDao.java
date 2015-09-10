package com.sdjz.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.sdjz.domain.Student;

public interface StudentDao extends JpaRepository<Student,Integer>,JpaSpecificationExecutor<Student> {
	public Student findByNo(String no);
	/*@Transactional
	public Student updateStudent(Student student);*/

}
