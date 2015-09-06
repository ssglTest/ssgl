package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdjz.domain.School;

public interface SchoolDao extends JpaRepository<School,Integer> {
	public School findByDescription(String description);
}
