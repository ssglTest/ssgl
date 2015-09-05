package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sdjz.domain.Tutor;

public interface TutorDao extends JpaRepository<Tutor,Integer>,JpaSpecificationExecutor<Tutor>{
	public Tutor findByNo(String no);

}
