package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperTitleApplyDao;
import com.sdjz.domain.PaperTitleApply;
import com.sdjz.domain.Student;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperTitleApplyService")
public class PaperTitleApplyService extends BasicService<PaperTitleApply, Integer>{

	private PaperTitleApplyDao paperTitleApplyDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<PaperTitleApply, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.paperTitleApplyDao = (PaperTitleApplyDao)basicDao;
	}
	public Page<PaperTitleApply> pageQueryBySecretary(Integer secreataryId){
		PageRequest pageRequest=new PageRequest(0,10);
		return paperTitleApplyDao.findBySecretary_id(secreataryId, pageRequest);
	}
}
