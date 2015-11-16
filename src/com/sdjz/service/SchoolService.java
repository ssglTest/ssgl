package com.sdjz.service;

import javax.persistence.EntityManager;

import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.SchoolDao;
import com.sdjz.domain.School;
import com.sdjz.jpaRepository.MyRepository;

@Service("schoolService")
public class SchoolService extends BasicService<School,Integer> {
	@SuppressWarnings("unused")
	private SchoolDao schoolDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<School, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.schoolDao=(SchoolDao)basicDao;
		
	}
	
}
