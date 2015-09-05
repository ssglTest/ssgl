package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.RoleDao;
import com.sdjz.domain.Role;
@Service("roleService")
public class RoleService {
	@Autowired
	RoleDao roleDao;
	public RoleService(){}
	public void saveRole(Role role){
		roleDao.save(role);
	}

}
