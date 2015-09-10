package com.sdjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.ActorDao;
import com.sdjz.domain.Actor;

@Service("actorService")
public class ActorService {
	@Autowired
	ActorDao actorDao;
	public ActorService(){}
	public void saveActor(Actor actor){
		actorDao.save(actor);
	}
	public void saveActors(List<Actor> actors){
		for(Actor actor:actors){
			actorDao.save(actor);
		}
	}
	public Actor findById(Integer id){
		return actorDao.findOne(id);
	}
	public Actor findByNo(String no){
		return actorDao.findByNo(no);
	}
	public List<Actor> findAll(){
		return actorDao.findAll();
	}

}
