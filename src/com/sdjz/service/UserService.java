package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.UserDao;
import com.sdjz.domain.User;
import com.sdjz.jpaRepository.MyRepository;

@Service("userService")
public class UserService extends BasicService<User,Integer> {
	private UserDao userDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<User, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.userDao=(UserDao)basicDao;
	}
	public User findByUserName(String name){
		return userDao.findByUserName(name);
	}

	
}
