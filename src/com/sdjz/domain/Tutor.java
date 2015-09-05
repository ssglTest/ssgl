package com.sdjz.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table(name="tutor")
public class Tutor extends Actor{

	private static final long serialVersionUID = 1L;
	private String title;//Ö°³Æ
	@OneToMany(mappedBy="tutor")
	private List<Student> students;
	
	public Tutor(){}
	public Tutor(String no,String name){
		super(no,name);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	

	
	

}
