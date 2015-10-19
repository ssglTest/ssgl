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
 * 硕士学位审批表
 * 
 * @author zhan
 *
 */
@Entity
@Table(name = "masterDegreeAudit")
@DynamicUpdate(true)
@DynamicInsert(true)
public class MasterDegreeAudit implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100)
	private String title;
	@Column(length = 100)
	private String updateDate;
	@Column(length = 100)
	private String auditDate;
	@Column(length = 50)
	private String approve;
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;
	@ManyToOne
	@JoinColumn(name = "secretary_id")
	private Secretary secretary;
	@Column(length = 100)
	private String url;

	public MasterDegreeAudit() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MasterDegreeAudit(Integer id, String title, String updateDate, String auditDate, String approve,
			Student student, School school, Secretary secretary, String url) {
		super();
		this.id = id;
		this.title = title;
		this.updateDate = updateDate;
		this.auditDate = auditDate;
		this.approve = approve;
		this.student = student;
		this.school = school;
		this.secretary = secretary;
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

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
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

}
