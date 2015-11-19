package com.sdjz.jpaRepository;

import java.io.Serializable;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

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
public void merge(T entity) {
	// TODO Auto-generated method stub
	
	//entityManager.remove(entityManager.merge(entity));
	entityManager.merge(entity);
	
}








@Override
public int countAll(Class<T> entityClass) {
	// TODO Auto-generated method stub
	CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();  
	CriteriaQuery<Long> critQuery = criteriaBuilder.createQuery(Long.class);  
	Root<T> root = critQuery.from(entityClass);  
	  
	critQuery.select(criteriaBuilder.countDistinct(root));  
	int count = entityManager.createQuery(critQuery).getSingleResult().intValue();  
	return count;
}




 

}