package com.sdjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.SchoolDao;
import com.sdjz.domain.School;

@Service("shoolService")
public class SchoolService {
	@Autowired
	SchoolDao schoolDao;
	public SchoolService(){}
	public void saveSchool(School school){
		schoolDao.save(school);
	}
	
	public void saveSchools(List<School> schools){
		for(School school:schools){
			schoolDao.save(school);
		}
	}
	public School findByName(String description){
		return schoolDao.findByDescription(description);
	}
	public List<School> findAll(){
		return schoolDao.findAll();
	}

}
