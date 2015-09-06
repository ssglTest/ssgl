package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdjz.domain.Secretary;

public interface SecretaryDao extends JpaRepository<Secretary,Integer> {
	//public Secretary findByName();

}
