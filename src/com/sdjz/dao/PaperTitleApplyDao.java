package com.sdjz.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sdjz.domain.PaperTitleApply;
import com.sdjz.jpaRepository.MyRepository;

public interface PaperTitleApplyDao extends MyRepository<PaperTitleApply,Integer>{
	public Page<PaperTitleApply> findBySecretary_id(Integer id,Pageable pageable);
}
