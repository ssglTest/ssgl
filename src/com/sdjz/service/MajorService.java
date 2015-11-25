package com.sdjz.service;


import java.util.List;
import java.util.Map;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springside.modules.persistence.DynamicSpecifications;
import org.springside.modules.persistence.SearchFilter;
import org.springside.modules.persistence.SearchFilter.Operator;

import com.sdjz.dao.MajorDao;
import com.sdjz.domain.Major;
import com.sdjz.jpaRepository.MyRepository;

@Service("majorService")
public class MajorService extends BasicService<Major,Integer>{
	@SuppressWarnings("unused")
	private MajorDao majorDao;
	@Autowired
	@Override
	public void setDasciDao(MyRepository<Major, Integer> basicDao) {
		// TODO Auto-generated method stub
		this.basicDao=basicDao;
		this.majorDao=(MajorDao)basicDao;
		
	}
	public List<Major> find(Integer schoolId,Map<String,Object> searchParams){
		Map<String, SearchFilter> filters = SearchFilter.parse(searchParams);
      filters.put("school.id", new SearchFilter("user.id", Operator.EQ, schoolId));
      Specification<Major> spec = DynamicSpecifications.bySearchFilter(filters.values(), Major.class);
		return majorDao.findAll(spec);
	}

}
