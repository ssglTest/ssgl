package com.sdjz.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	//审核是否通过
	@Column(length=10)
	private boolean approved;
	//审核日期
	@Column(length=20)
	private Calendar auditDate;
	
	@OneToOne(mappedBy="audit")
	private PaperTitleApply paperTitleApply;
	
	public Audit() {
		super();
	}

	public Audit(boolean approved, Calendar auditDate) {
		super();
		this.approved = approved;
		this.auditDate = auditDate;
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
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
