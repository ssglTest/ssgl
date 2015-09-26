package com.sdjz.jpaRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import javax.persistence.EntityManager;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //必须的
public class MyRepositoryImplement<T, ID extends Serializable> 
extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

	
private final EntityManager entityManager;


public MyRepositoryImplement(Class<T> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
		
		entityManager=em;
	}

public MyRepositoryImplement(final JpaEntityInformation<T, ?> entityInformation, final EntityManager entityManager) {
    super(entityInformation, entityManager);
    this.entityManager = entityManager;
}


@Override
public void merge(T entiry) {
	// TODO Auto-generated method stub
	entityManager.merge(entiry);
	
}
 

}