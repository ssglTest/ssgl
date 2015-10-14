package com.sdjz.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="major")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Major implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=20)
	private String description;
	@Column(length=10)
	private String no;
	@ManyToOne
	@JoinColumn(name="school_id")
	private School school;
	@OneToMany(mappedBy="major")
	private List<Student> students;
	@OneToMany(mappedBy="major")
	private List<Tutor> tutors;
	@OneToMany(mappedBy="major")
	private List<Teacher> teachers;
	
	public Major(){}
	public Major(String description){
		this.description=description;
	}
	public Major(String description,String no){
		this.description=description;
		this.no=no;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlTransient
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	
	public List<Student> getStudents() {
		return students;
	}
	public void setStudents(List<Student> students) {
		this.students = students;
	}
	public List<Tutor> getTutors() {
		return tutors;
	}
	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}
	public List<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}
	

}
