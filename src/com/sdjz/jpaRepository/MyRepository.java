package com.sdjz.jpaRepository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface MyRepository <T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T> {
	public void merge(T entiry);
	public int countAll(Class<T> entityClass);
	

}
