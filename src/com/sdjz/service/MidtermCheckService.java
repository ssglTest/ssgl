package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.MidtermCheckDao;
import com.sdjz.domain.MidtermCheck;
import com.sdjz.jpaRepository.MyRepository;

@Service("midtermCheckService")
public class MidtermCheckService extends BasicService<MidtermCheck, Integer> {

	@SuppressWarnings("unused")
	private MidtermCheckDao midtermCheckDao;

	@Autowired
	@Override
	public void setDasciDao(MyRepository<MidtermCheck, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.midtermCheckDao = (MidtermCheckDao) basicDao;
	}

}
