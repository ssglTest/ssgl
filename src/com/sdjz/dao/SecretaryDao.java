package com.sdjz.dao;




import com.sdjz.domain.Secretary;
import com.sdjz.jpaRepository.MyRepository;

public interface SecretaryDao extends MyRepository<Secretary,Integer> {
	public Secretary findByNo(String no);
}
