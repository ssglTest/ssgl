package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperChooseTitleDao;
import com.sdjz.domain.PaperChooseTitle;
import com.sdjz.domain.Student;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperChooseTitleService")
public class PaperChooseTitleService extends BasicService<PaperChooseTitle, Integer>{

	private PaperChooseTitleDao paperChooseTitleDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<PaperChooseTitle, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.paperChooseTitleDao = (PaperChooseTitleDao)basicDao;
	}
	
	public Student findByNo(String no){
		return paperChooseTitleDao.findByStudent(no);
	}

}
