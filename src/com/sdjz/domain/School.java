package com.sdjz.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="school")
public class School {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=20)
	private String description;
	@OneToMany(mappedBy="school")
	private List<Student> students;
	@OneToMany(mappedBy="school")
	private List<Tutor> tutors;
	@OneToMany(mappedBy="school")
	private List<Major> majors;
	@OneToOne(mappedBy="school")
	private Secretary secretary;
	
	public School(){}
	public School(String description){
		this.description=description;
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
	public void setDescription(String description) {
		this.description = description;
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
	
	public List<Major> getMajors() {
		return majors;
	}
	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}
	public Secretary getSecretary() {
		return secretary;
	}
	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}
	
	
	

}
