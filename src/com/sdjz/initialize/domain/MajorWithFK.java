package com.sdjz.initialize.domain;

import java.io.Serializable;


public class MajorWithFK implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String description;
	private String no;
	private Integer schoolId;
	
	public MajorWithFK(){}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	

}
