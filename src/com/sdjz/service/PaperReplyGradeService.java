package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperReplyGradeDao;
import com.sdjz.domain.PaperReplyGrade;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperReplyGradeService")
public class PaperReplyGradeService extends BasicService<PaperReplyGrade, Integer> {

	@SuppressWarnings("unused")
	private PaperReplyGradeDao paperReplyGradeDao;

	@Autowired
	@Override
	public void setDasciDao(MyRepository<PaperReplyGrade, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.paperReplyGradeDao = (PaperReplyGradeDao) basicDao;
	}

}
