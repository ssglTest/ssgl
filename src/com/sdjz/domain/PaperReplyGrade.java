package com.sdjz.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 学位论文答辩成绩
 * 
 * @author zhan
 *
 */
@Entity
@Table(name = "paperReplyGrade")
@DynamicInsert(true)
@DynamicUpdate(true)
public class PaperReplyGrade implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String name;
	@Column(length = 50)
	private String no;
	@Column(length = 50)
	private String grade;
	@Column(length = 100)
	private String url;
	
	@OneToOne
	@JoinColumn(name="student_id")
	private Student student;

	public PaperReplyGrade() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaperReplyGrade(String url){
		this.url=url;
	}

	public PaperReplyGrade(Integer id, String name, String no, String grade, String url) {
		super();
		this.id = id;
		this.name = name;
		this.no = no;
		this.grade = grade;
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
	

}
