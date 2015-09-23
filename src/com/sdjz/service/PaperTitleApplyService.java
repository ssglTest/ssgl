package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperTitleApplyDao;
import com.sdjz.domain.PaperTitleApply;
import com.sdjz.domain.Student;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperChooseTitleService")
public class PaperTitleApplyService extends BasicService<PaperTitleApply, Integer>{

	private PaperTitleApplyDao paperChooseTitleDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<PaperTitleApply, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.paperChooseTitleDao = (PaperTitleApplyDao)basicDao;
	}
}
