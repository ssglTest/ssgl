package com.sdjz.initialize.domain;


public class TeacherWithFK extends Actor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer schoolId;
	private Integer MajorId;
	public TeacherWithFK(){
		super();
	}
	public Integer getSchoolId() {
		return schoolId;
	}
	public void setSchoolId(Integer schoolId) {
		this.schoolId = schoolId;
	}
	public Integer getMajorId() {
		return MajorId;
	}
	public void setMajorId(Integer majorId) {
		MajorId = majorId;
	}
	
	

}
