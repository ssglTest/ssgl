package com.sdjz.dao;


import com.sdjz.domain.Tutor;
import com.sdjz.jpaRepository.MyRepository;

public interface TutorDao extends MyRepository<Tutor,Integer>{
	public Tutor findByNo(String no);

}
