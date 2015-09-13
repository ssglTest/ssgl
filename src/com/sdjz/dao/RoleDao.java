package com.sdjz.dao;

import com.sdjz.domain.Role;
import com.sdjz.jpaRepository.MyRepository;

public interface RoleDao extends MyRepository<Role,Integer> {
	public Role findByDescription(String description);

}
