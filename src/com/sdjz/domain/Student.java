package com.sdjz.domain;

import java.util.List;


import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "student")
public class Student extends Actor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;
	@ManyToMany
	@JoinTable(name="student_teacher")
	private List<Teacher> teachers;
	@OneToOne(mappedBy="student")
	private PaperTitleApply paperTitleApply;
	@OneToOne(mappedBy="student")
	private PaperTitleReport paperTitleReport;
	@OneToOne(mappedBy="student")
	private MidtermCheck midtermCheck;
	public Student() {
	}

	public Student(String no, String name) {
		super(no, name);
	}
	
	public MidtermCheck getMidtermCheck() {
		return midtermCheck;
	}

	public void setMidtermCheck(MidtermCheck midtermCheck) {
		this.midtermCheck = midtermCheck;
	}

	@XmlTransient
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}
	@XmlTransient
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public PaperTitleApply getPaperTitleApply() {
		return paperTitleApply;
	}

	public void setPaperTitleApply(PaperTitleApply paperTitleApply) {
		this.paperTitleApply = paperTitleApply;
	}

	public PaperTitleReport getPaperTitleReport() {
		return paperTitleReport;
	}

	public void setPaperTitleReport(PaperTitleReport paperTitleReport) {
		this.paperTitleReport = paperTitleReport;
	}
	
	


}
