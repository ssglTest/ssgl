package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.AuditDao;
import com.sdjz.domain.Audit;
import com.sdjz.jpaRepository.MyRepository;

@Service("auditService")
public class AuditService extends BasicService<Audit, Integer> {

	private AuditDao auditDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Audit, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.auditDao = (AuditDao) basicDao;
	}

}
