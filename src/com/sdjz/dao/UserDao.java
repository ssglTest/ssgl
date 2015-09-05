package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.sdjz.domain.User;





public interface UserDao extends JpaRepository<User,Integer> ,JpaSpecificationExecutor<User>{
	public User findByUserName(String username);
	

}
