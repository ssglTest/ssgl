package com.sdjz.service;


import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
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
	public Role specification(){
		Role list=roleDao.findOne(new Specification<Role>(){

			@Override
			public Predicate toPredicate(Root<Role> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Predicate p1=cb.equal(root.get("no").as(String.class),"001");
				query.where(p1);
				return query.getRestriction();
			}
			
		});
		return list;
	}
}
