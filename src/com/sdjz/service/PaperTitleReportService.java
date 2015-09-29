package com.sdjz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdjz.dao.PaperTitleReportDao;
import com.sdjz.domain.PaperTitleReport;
import com.sdjz.jpaRepository.MyRepository;

@Service("paperTitleReportService")
public class PaperTitleReportService extends BasicService<PaperTitleReport, Integer> {

	@SuppressWarnings("unused")
	private PaperTitleReportDao paperTitleReportDao;

	@Autowired
	@Override
	public void setDasciDao(MyRepository<PaperTitleReport, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao = basicDao;
		this.paperTitleReportDao = (PaperTitleReportDao) basicDao;

	}
}
