package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.SciencePaperCheckDao;
import com.sdjz.domain.SciencePaperCheck;
import com.sdjz.jpaRepository.MyRepository;

@Service("sciencePaperCheckService")
public class SciencePaperCheckService extends BasicService<SciencePaperCheck, Integer> {

	@SuppressWarnings("unused")
	private SciencePaperCheckDao sciencePaperCheckDao;

	@Autowired
	@Override
	public void setDasciDao(MyRepository<SciencePaperCheck, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.sciencePaperCheckDao = (SciencePaperCheckDao) basicDao;
	}

}
