package com.sdjz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
	
	public Role findOne(String propertyName,String propertyValue){
		Role role=roleDao.findOne(this.get(propertyName, propertyValue));
		return role;
	}
	public List<Role> getAll(String propertyName,String propertyValue){
		List<Role> result=roleDao.findAll(this.get(propertyName, propertyValue));
		return result;
	}
	public List<Role> likeQuery(String propertyName,String propertyValue){
		List<Role> result=roleDao.findAll(this.likequery(propertyName, propertyValue));
		return result;
	}
	public List<Role> pageQuery(String propertyName,String propertyValue){
		Page<Role> result=roleDao.findAll(this.get(propertyName, propertyValue),
				new PageRequest(0,10));
		return result.getContent();
	}
	public List<Role> pageLikeQuery(String propertyName,String propertyValue){
		Page<Role> result=roleDao.findAll(this.likequery(propertyName, propertyValue),
										new PageRequest(0,10));
		return result.getContent();
	}
}
