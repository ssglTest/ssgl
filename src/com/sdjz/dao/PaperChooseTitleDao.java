package com.sdjz.dao;

import com.sdjz.domain.PaperChooseTitle;
import com.sdjz.domain.Student;
import com.sdjz.jpaRepository.MyRepository;

public interface PaperChooseTitleDao extends MyRepository<PaperChooseTitle,Integer>{
	public Student findByStudent(String no);
}
