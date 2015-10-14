package com.sdjz.initialize.domain;


public class TutorWithFK extends Actor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer schoolId;
	private Integer majorId;
	
	public TutorWithFK(){
		super();
	}

	public Integer getSchoolId() {
		return schoolId;
	}

	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}

	public Integer getMajorId() {
		return majorId;
	}

	public void setMajorId(Integer majorId) {
		this.majorId = majorId;
	}
	
	

}
