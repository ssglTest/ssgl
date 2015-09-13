package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.SecretaryDao;
import com.sdjz.domain.Secretary;
import com.sdjz.jpaRepository.MyRepository;

@Service("secretaryService")
public class SecretaryService extends BasicService<Secretary,Integer> {
	private SecretaryDao secretaryDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Secretary, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.secretaryDao=(SecretaryDao)basicDao;
	}
	public Secretary findByNo(String no){
		return secretaryDao.findByNo(no);
	}
}
