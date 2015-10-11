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
 * 学术论文考核记录表
 * 
 * @author zhan
 *
 */
@Entity
@Table(name = "sciencePaperCheck")
@DynamicInsert(true)
@DynamicUpdate(true)
public class SciencePaperCheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100)
	private String title;
	@Column(length = 50)
	private String updataDate;
	@Column(length = 50)
	private String auditDate;
	@Column(length = 100)
	private String url;
	@Column(length = 20)
	private String approve;
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public SciencePaperCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SciencePaperCheck(Integer id, String title, String updataDate, String auditDate, String url, String approve,
			Student student) {
		super();
		this.id = id;
		this.title = title;
		this.updataDate = updataDate;
		this.auditDate = auditDate;
		this.url = url;
		this.approve = approve;
		this.student = student;
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

	public String getUpdataDate() {
		return updataDate;
	}

	public void setUpdataDate(String updataDate) {
		this.updataDate = updataDate;
	}

	public String getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
	}

}
