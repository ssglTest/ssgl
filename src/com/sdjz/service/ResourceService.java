package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.ResourceDao;
import com.sdjz.domain.Resource;
import com.sdjz.jpaRepository.MyRepository;
@Service("resourceService")
public class ResourceService extends BasicService<Resource,Integer>{
	@SuppressWarnings("unused")
	private ResourceDao resourceDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Resource, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.resourceDao=(ResourceDao)basicDao;
	}

}
