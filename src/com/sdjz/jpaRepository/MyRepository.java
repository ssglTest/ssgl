package com.sdjz.jpaRepository;

import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface MyRepository <T,ID extends Serializable> extends JpaRepository<T,ID> {
	public void merge(T entiry);
	

}
