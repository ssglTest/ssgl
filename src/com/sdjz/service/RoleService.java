package com.sdjz.service;

import java.util.List;

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
	public void saveRoles(List<Role> roles){
		for(Role role:roles){
			roleDao.save(role);
		}
	}
	public Role findById(Integer id){
		return roleDao.findOne(id);
	}
	public Role findByDescription(String description){
		return roleDao.findByDescription(description);
	}
	
	public List<Role> findAll(){
		return roleDao.findAll();
	}

}
