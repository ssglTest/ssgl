package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.sdjz.dao.UserRoleDao;
import com.sdjz.domain.UserRole;
import com.sdjz.jpaRepository.MyRepository;

@Service("userRoleService")
public class UserRoleService extends BasicService<UserRole,Integer> {
	
	@SuppressWarnings("unused")
	private UserRoleDao userRoleDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<UserRole, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.userRoleDao=(UserRoleDao)basicDao;
	}
	

}
