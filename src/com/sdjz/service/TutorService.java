package com.sdjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.TutorDao;
import com.sdjz.domain.Tutor;

@Service("tutorService")
public class TutorService {
	@Autowired
	TutorDao tutorDao;
	public TutorService(){}
	public void saveTutor(Tutor tutor){
		tutorDao.save(tutor);
	}
	public void saveTutors(List<Tutor> tutors){
		for(Tutor tutor:tutors){
			tutorDao.save(tutor);
		}
	}
	public Tutor findByNo(String no){
		return tutorDao.findByNo(no);
	}
	public Tutor findById(Integer id){
		return tutorDao.findOne(id);
	}
	public List<Tutor> findAll(){
		return tutorDao.findAll();
	}

}
