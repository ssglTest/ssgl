package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperReplyApplyDao;
import com.sdjz.domain.PaperReplyApply;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperReplyApplyService")
public class PaperReplyApplyService extends BasicService<PaperReplyApply, Integer> {

	@SuppressWarnings("unused")
	private PaperReplyApplyDao papeReplyApplyDao;

	@Autowired
	@Override
	public void setDasciDao(MyRepository<PaperReplyApply, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.papeReplyApplyDao = (PaperReplyApplyDao) basicDao;

	}

}
