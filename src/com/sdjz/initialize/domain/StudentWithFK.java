package com.sdjz.initialize.domain;


public class StudentWithFK extends Actor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer schoolId;
	private Integer majorId;
	private Integer teacherId;
	private Integer tutorId;
	
	public StudentWithFK(){
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

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public Integer getTutorId() {
		return tutorId;
	}

	public void setTutorId(Integer tutorId) {
		this.tutorId = tutorId;
	}
	
		

}
