package com.sdjz.domain;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Secretary extends Actor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name="school_id")
	private School school;
	
	public Secretary(){}
	public Secretary(String no,String name){
		super(no,name);		
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	

}
