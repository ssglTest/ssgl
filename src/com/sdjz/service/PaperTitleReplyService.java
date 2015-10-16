package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperTitleReplyDao;
import com.sdjz.domain.PaperTitleReply;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperTitleReplyService")
public class PaperTitleReplyService extends BasicService<PaperTitleReply, Integer>{

	@SuppressWarnings("unused")
	private PaperTitleReplyDao paperTitleReplyDao;
	@Override
	@Autowired
	public void setDasciDao(MyRepository<PaperTitleReply, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.paperTitleReplyDao = (PaperTitleReplyDao)basicDao;
	}

}
