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
 * 中期检查表的实体类
 * @author zhan
 *
 */
@Entity
@Table(name = "midtermCheck")
@DynamicInsert(true)
@DynamicUpdate(true)
public class MidtermCheck implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 50)
	private String title;
	@Column(length = 15)
	private String approve;
	@Column(length = 100)
	private String updateDate;
	@Column(length = 100)
	private String auditDate;
	@Column(length=100)
	private String url;
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;

	public MidtermCheck() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MidtermCheck(Integer id, String title, String approve, String updateDate, String auditDate, String url,
			Student student) {
		super();
		this.id = id;
		this.title = title;
		this.approve = approve;
		this.updateDate = updateDate;
		this.auditDate = auditDate;
		this.url = url;
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

	public String getApprove() {
		return approve;
	}

	public void setApprove(String approve) {
		this.approve = approve;
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

	
	
}
