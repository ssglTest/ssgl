package com.sdjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.SecretaryDao;
import com.sdjz.domain.Secretary;

@Service("secretaryService")
public class SecretaryService {
	@Autowired
	SecretaryDao secretaryDao;
	public SecretaryService(){}
	public void saveSecretary(Secretary secretary){
		secretaryDao.save(secretary);
	}
	public void saveSecretaries(List<Secretary> secretaries){
		for(Secretary secretary:secretaries){
		secretaryDao.save(secretary);
		}
	}
	public Secretary findByNo(String no){
		return secretaryDao.findByNo(no);
	}
	public Secretary findById(Integer id){
		return secretaryDao.findOne(id);
	}
	public List<Secretary> findAll(){
		return secretaryDao.findAll();
	}

}
