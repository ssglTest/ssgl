package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperReplyNotifiCationDao;
import com.sdjz.domain.PaperReplyNotifiCation;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperReplyNotifiCationService")
public class PaperReplyNotifiCationService extends BasicService<PaperReplyNotifiCation, Integer> {

	@SuppressWarnings("unused")
	private PaperReplyNotifiCationDao paperReplyNotifiCationDao;

	@Autowired
	@Override
	public void setDasciDao(MyRepository<PaperReplyNotifiCation, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.paperReplyNotifiCationDao = (PaperReplyNotifiCationDao) basicDao;
	}

}
