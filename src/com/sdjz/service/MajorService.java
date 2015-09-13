package com.sdjz.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.MajorDao;
import com.sdjz.domain.Major;
import com.sdjz.jpaRepository.MyRepository;

@Service("majorService")
public class MajorService extends BasicService<Major,Integer>{
	@SuppressWarnings("unused")
	private MajorDao majorDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Major, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.majorDao=(MajorDao)basicDao;
		
	}
	

}
