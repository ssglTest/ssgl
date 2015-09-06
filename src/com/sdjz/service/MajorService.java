package com.sdjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.MajorDao;
import com.sdjz.domain.Major;

@Service("majorService")
public class MajorService {
	@Autowired
	MajorDao majorDao;
	public MajorService(){}
	public void saveMajor(Major major){
		majorDao.save(major);
	}
	public void saveMajors(List<Major> majors){
		for(Major major:majors){
			majorDao.save(major);
		}
	}
	public Major findByDescription(String description){
		return majorDao.findByDescription(description);
	}
	public Major findById(Integer id){
		return majorDao.findOne(id);
	}
	public List<Major> findAll(){
		return majorDao.findAll();
	}

}
