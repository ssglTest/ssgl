package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdjz.domain.Actor;

public interface ActorDao extends JpaRepository<Actor,Integer>{
	public Actor findByNo(String no);

}
