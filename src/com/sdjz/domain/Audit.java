package com.sdjz.domain;

import java.io.Serializable;
import java.util.Calendar;

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
@Table(name="audit")
@DynamicInsert(true)
@DynamicUpdate(true)
//审核状态表
public class Audit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	//审核状态位通过
	@Column(length=4)
	private String pass;
	@Column(length=4)
	private String notPass;
	//审核日期
	@Column(length=20)
	private Calendar auditDate;
	
	@OneToOne(mappedBy="audit")
	@JoinColumn(name="paperTitleApply_id")
	private PaperTitleApply paperTitleApply;
	
	public Audit() {
		super();
	}
	public Audit(Calendar auditDate){
		this.auditDate=auditDate;
	}
	public Audit(String pass,String notPass){
		this.pass=pass;
		this.notPass=notPass;
	}

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getNotPass() {
		return notPass;
	}


	public void setNotPass(String notPass) {
		this.notPass = notPass;
	}


	public Calendar getAuditDate() {
		return auditDate;
	}


	public void setAuditDate(Calendar auditDate) {
		this.auditDate = auditDate;
	}


	public PaperTitleApply getPaperTitleApply() {
		return paperTitleApply;
	}

	public void setPaperTitleApply(PaperTitleApply paperTitleApply) {
		this.paperTitleApply = paperTitleApply;
	}
	
	
	
}
