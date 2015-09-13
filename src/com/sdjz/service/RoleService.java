package com.sdjz.service;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.sdjz.dao.RoleDao;
import com.sdjz.domain.Role;
import com.sdjz.jpaRepository.MyRepository;
@Service("roleService")
public class RoleService extends BasicService<Role,Integer>{
	private RoleDao roleDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Role, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.roleDao=(RoleDao)basicDao;		
	}
	public Role findByDescription(String description){
		return roleDao.findByDescription(description);
	}
}
