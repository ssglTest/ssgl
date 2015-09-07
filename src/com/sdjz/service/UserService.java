package com.sdjz.service;

import java.util.List;





import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Service;

import com.sdjz.dao.UserDao;
import com.sdjz.domain.User;

@Service("userService")
public class UserService {

	public UserService() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	UserDao userDao;
	public void saveUser(User user){
		userDao.save(user);
	}
	public void saveUsers(List<User> users){
		for(User user:users){
			userDao.save(user);
		}
	}
	
	public User findByUserName(String username){
		return userDao.findByUserName(username);
	}
	public User findById(Integer id){
		return userDao.findOne(id);
	}
	
	public List<User> findAll(){
		
		return userDao.findAll();
	}

}