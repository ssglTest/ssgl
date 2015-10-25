package com.sdjz.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

/**
 * 学位论文答辩申请书的实体类
 * 
 * @author zhan
 *
 */
@Entity
@Table(name = "paperReplyApply")
@DynamicInsert(true)
@DynamicUpdate(true)
public class PaperReplyApply implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String updateDate;
	@Column(length = 50)
	private String auditDate;
	@Column(length = 50)
	private String title;
	@Column(length = 100)
	private String url;
	@Column(length = 50)
	private String approve;// 审核状态
	
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;
	@ManyToOne
	@JoinColumn(name = "secretary_id")
	private Secretary secretary;
	

	public PaperReplyApply() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PaperReplyApply(String title,String url){
		this.title=title;
		this.url=url;
	}

	public PaperReplyApply(Integer id, String updateDate, String auditDate, String title, String url, Student student,
			School school, Secretary secretary, String approve) {
		super();
		this.id = id;
		this.updateDate = updateDate;
		this.auditDate = auditDate;
		this.title = title;
		this.url = url;
		this.student = student;
		this.school = school;
		this.secretary = secretary;
		this.approve = approve;
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

	public String getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(String updateDate) {
		this.updateDate = updateDate;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Secretary getSecretary() {
		return secretary;
	}

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

}
