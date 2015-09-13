package com.sdjz.dao;

import com.sdjz.domain.User;
import com.sdjz.jpaRepository.MyRepository;
public interface UserDao extends MyRepository<User,Integer>{
	public User findByUserName(String name);
	

}
