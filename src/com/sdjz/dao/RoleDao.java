package com.sdjz.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sdjz.domain.Role;

public interface RoleDao extends JpaRepository<Role,Integer> {
	public Role findByDescription(String description);

}
