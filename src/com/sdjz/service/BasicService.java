package com.sdjz.service;


import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import com.sdjz.jpaRepository.MyRepository;


public abstract class BasicService<T extends java.io.Serializable, PK extends java.io.Serializable> {
		
	MyRepository<T, PK> basicDao;
	// 泛型反射类
	//Class<T> entityClass;
	public abstract void setDasciDao(MyRepository<T,PK> basicDao);
	
	// 通过反射获取子类确定的泛型类
	/*@SuppressWarnings({ "rawtypes", "unchecked" })
	public BasicService() {
		// getGenericSuperclass() 通过反射获取当前类表示的实体（类，接口，基本类型或void）的直接父类的Type
		Type genType = getClass().getGenericSuperclass();
		//getActualTypeArguments()返回参数数组
		Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
		entityClass = (Class) params[0];
		
	}
	*/
	public void save(T entity){
		basicDao.save(entity);
	}
	
	public void saves(List<T> entities){
		for(T entity:entities){
			basicDao.save(entity);
		}
	}
	public void saveAndFlush(T entity){
		basicDao.saveAndFlush(entity);
	}
	public T findById(PK id){
		return basicDao.findOne(id);
	}
	public void update(T entity){
		basicDao.merge(entity);
	}
	public void deleteById(PK id){
		basicDao.delete(id);
	}
	public void deleteByObject(T entity){
		basicDao.delete(entity);
	}
	public void deleteAll(){
		basicDao.deleteAll();
	}
	public List<T> findAll(){
		return basicDao.findAll();
	}
	public long countAll(Class<T> entityClass){
		return basicDao.countAll(entityClass);
	}
	public Specification<T> get(String propertyName,String propertyValue){
		return new Specification<T>(){

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Predicate condition=cb.equal(root.get(propertyName).as(String.class), propertyValue);
				query.where(condition);
				return query.getRestriction();
			}			
		};
	}

	public Specification<T> likequery(String propertyName,String propertyValue){
		return new Specification<T>(){
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				Predicate condition=cb.like(root.get(propertyName).as(String.class),"%"+propertyValue+"%");
				query.where(condition);
				return query.getRestriction();
			}			
		};		
	}
	public Specification<T> relatedQuery(){	
		return new Specification<T>(){
			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				// TODO Auto-generated method stub	
				//SetJoin<T,T> depJion=root.join(root.getModel().getSet());
				return null;
			}					
		};
	}
	
}
