package com.sdjz.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name="teacher")
public class Teacher extends Actor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	@ManyToOne
	@JoinColumn(name="major_id")
	private Major major;
	@ManyToMany(mappedBy="teachers")
	private List<Student> students;
	
	public Teacher(){}
	public Teacher(String no,String name){
		super(no,name);
	}
	@XmlTransient
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	@XmlTransient
	public Major getMajor() {
		return major;
	}
	public void setMajor(Major major) {
		this.major = major;
	}
	@XmlTransient
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	

}
