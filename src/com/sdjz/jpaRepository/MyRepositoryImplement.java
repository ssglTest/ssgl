package com.sdjz.jpaRepository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean //必须的
public class MyRepositoryImplement<T, ID extends Serializable> 
extends SimpleJpaRepository<T, ID> implements MyRepository<T, ID> {

	
private final EntityManager entityManager;
private CriteriaBuilder criteriaBuilder;
private CriteriaQuery<T> criteriaQuery;
private Root<T> model;
private Class<T> entityClass;
private EntityType<T> Model_;


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

@Override
public T getResult(Class<T> entityClass,String propertyName,Object propertyValue) {
	// TODO Auto-generated method stub
	this.entityClass=entityClass;	
	this.initilize();
	criteriaQuery.where(criteriaBuilder.equal(model.get(Model_.getSingularAttribute(propertyName,String.class)), propertyValue));
	return entityManager.createQuery(criteriaQuery).getSingleResult();
}

@Override
public List<T> likeQuery(Class<T> entityClass,String propertyName,Object propertyValue) {
	// TODO Auto-generated method stub
	this.entityClass=entityClass;
	this.initilize();
	criteriaQuery.where(criteriaBuilder.like(model.get(Model_.getSingularAttribute(propertyName,String.class)), "%"+propertyValue+"%"));
	return entityManager.createQuery(criteriaQuery).getResultList();
}

@Override
public List<T> pageQuery(Class<T> entityClass, String propertyName, Object propertyValue) {
	// TODO Auto-generated method stub
	
	return null;
}

public void init(){
	 criteriaBuilder =entityManager.getCriteriaBuilder();
	 criteriaQuery=criteriaBuilder.createQuery(entityClass);
	 model=criteriaQuery.from(entityClass);
	 Model_=model.getModel();
}
public void initilize(){
	if(criteriaBuilder==null){
		this.init();
	}
}


 

}