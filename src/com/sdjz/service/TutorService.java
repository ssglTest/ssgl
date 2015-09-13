package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.TutorDao;
import com.sdjz.domain.Tutor;
import com.sdjz.jpaRepository.MyRepository;

@Service("tutorService")
public class TutorService extends BasicService<Tutor,Integer>{
	private TutorDao tutorDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Tutor, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.tutorDao=(TutorDao)basicDao;
	}
	public Tutor findByNo(String no){
		return tutorDao.findByNo(no);
	}
	
	
}
