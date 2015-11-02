package com.sdjz.jpaRepository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface MyRepository <T,ID extends Serializable> extends JpaRepository<T,ID>,JpaSpecificationExecutor<T> {
	public void merge(T entiry);
	public T getResult(Class<T> entityClass,String propertyName,Object propertyValue);
	public List<T> getResults(Class<T> entityClass,String propertyName,Object propertyValue);
	public List<T> getResult(Class<T> entityClass,String propertyName1,Object propertyValue1,String propertyName2,Object propertyValue2 );
	public List<T> likeQuery(Class<T> entityClass,String propertyName,Object propertyValue);
	//public List<T> pageQuery(Class<T> entityClass,String propertyName,Object propertyValue);
	

}
