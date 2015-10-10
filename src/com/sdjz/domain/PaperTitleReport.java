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

@Entity
@DynamicInsert(true)
@DynamicUpdate(true)
@Table(name = "paperTitleReport")
/**
 * 论文选题报告的实体类
 * 
 * @author zhan
 *
 */
public class PaperTitleReport implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 100)
	private String url;
	@Column(length = 20)
	private String title;
	@Column(length = 30)
	private String updateDate;
	@Column(length = 15)
	private String approve;
	@Column(length = 15)
	private String auditDate;
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public PaperTitleReport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaperTitleReport(Integer id, String url, String title, String updateDate, String approve, String auditDate,
			Student student) {
		super();
		this.id = id;
		this.url = url;
		this.title = title;
		this.updateDate = updateDate;
		this.approve = approve;
		this.auditDate = auditDate;
		this.student = student;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
