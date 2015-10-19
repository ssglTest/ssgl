package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.MasterDegreeAuditDao;
import com.sdjz.domain.MasterDegreeAudit;
import com.sdjz.jpaRepository.MyRepository;

@Service("masterDegreeAuditService")
public class MasterDegreeAuditService extends BasicService<MasterDegreeAudit, Integer> {

	@SuppressWarnings("unused")
	private MasterDegreeAuditDao masterDegreeAuditDao;

	@Autowired
	@Override
	public void setDasciDao(MyRepository<MasterDegreeAudit, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.masterDegreeAuditDao = (MasterDegreeAuditDao) basicDao;

	}

}
