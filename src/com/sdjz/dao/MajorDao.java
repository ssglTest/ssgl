package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdjz.domain.Major;

public interface MajorDao extends JpaRepository<Major,Integer>{
	public Major findByDescription(String description);

}
