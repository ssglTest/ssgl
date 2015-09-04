package testdatajpa.service;

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

import testdatajpa.dao.UserDao;
import testdatajpa.domain.User;

@Service("userService")
public class UserService {
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
	
	public List<User> findAll(){
		
		return userDao.findAll();
	}

}
