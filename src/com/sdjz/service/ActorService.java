package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.ActorDao;
import com.sdjz.domain.Actor;
import com.sdjz.jpaRepository.MyRepository;
@Service("actorService")
public class ActorService extends BasicService<Actor,Integer>{
	private ActorDao actorDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Actor, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.actorDao=(ActorDao)basicDao;
		
	}

}
