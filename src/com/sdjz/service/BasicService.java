package com.sdjz.service;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
	public long countAll(){
		return basicDao.count();
	}
	public T getResult(Class<T> entityClass,String propertyName,Object propertyValue){
		
		return basicDao.getResult(entityClass, propertyName,propertyValue);
		
	}
	public List<T> getResults(Class<T> entityClass,String propertyName,Object propertyValue) {
		return basicDao.getResults(entityClass, propertyName, propertyValue);
	}
	
	
	public List<T> getResults(Class<T> entityClass,String propertyName1,String propertyValue1,String propertyName2,String propertyValue2){
		return basicDao.getResult(entityClass, propertyName1, propertyValue1, propertyName2, propertyValue2);
	}
	
	public List<T> likeQuery(Class<T> entityClass,String propertyName,Object propertyValue){
		return basicDao.likeQuery(entityClass, propertyName, propertyValue);
	}
	/*public T specification(Class<T> entityClass){
			T result=basicDao.findOne(new Specification<T>(){

			@Override
			public Predicate toPredicate(Root<T> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
				// TODO Auto-generated method stub
				root=cq.from(entityClass);
				Path<String> nameExp=root.get("no");
				
				return cb.equal(nameExp,"001");
			}
			
		});
		return result;
		
	}*/
	
	
}
