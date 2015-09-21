package com.sdjz.domain;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="audit")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Audit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	@Column(length=10)
	private boolean approved;
	@Column(length=20)
	private Calendar auditDate;
	
	public Audit() {
		super();
	}

	public Audit(boolean approved, Calendar auditDate) {
		super();
		this.approved = approved;
		this.auditDate = auditDate;
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
	
	
	
}
