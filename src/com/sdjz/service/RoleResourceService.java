package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.RoleResourceDao;
import com.sdjz.domain.RoleResource;
import com.sdjz.jpaRepository.MyRepository;

@Service("roleResourceService")
public class RoleResourceService extends BasicService<RoleResource,Integer> {
	@SuppressWarnings("unused")
	private RoleResourceDao roleResourceDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<RoleResource, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.roleResourceDao=(RoleResourceDao)basicDao;
	}

}
