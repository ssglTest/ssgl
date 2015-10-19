package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperElectronicEditionDao;
import com.sdjz.domain.PaperElectronicEdition;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperElectronicEditionService")
public class PaperElectronicEditionService extends BasicService<PaperElectronicEdition, Integer> {

	@SuppressWarnings("unused")
	private PaperElectronicEditionDao paperElectronicEditionDao;

	@Autowired
	@Override
	public void setDasciDao(MyRepository<PaperElectronicEdition, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.paperElectronicEditionDao = (PaperElectronicEditionDao) basicDao;

	}

}
