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
@Table(name = "paperChooseTitle")
@DynamicUpdate(true)
@DynamicInsert(true)
public class PaperChooseTitle implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(length = 200)
	private String url;
	@OneToOne
	@JoinColumn(name = "student_id")
	private Student student;
	@Column(length = 100)
	private Audit auditBySecretary;
	@Column(length = 100)
	private String title;

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public PaperChooseTitle() {
		super();

	}

	public PaperChooseTitle(String url, Audit auditBySecretary) {
		super();
		this.url = url;
		this.auditBySecretary = auditBySecretary;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Audit getAuditBySecretary() {
		return auditBySecretary;
	}

	public void setAuditBySecretary(Audit auditBySecretary) {
		this.auditBySecretary = auditBySecretary;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((auditBySecretary == null) ? 0 : auditBySecretary.hashCode());
		result = prime * result + ((url == null) ? 0 : url.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PaperChooseTitle other = (PaperChooseTitle) obj;
		if (auditBySecretary == null) {
			if (other.auditBySecretary != null)
				return false;
		} else if (!auditBySecretary.equals(other.auditBySecretary))
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PaperChooseTitle [id=" + id + ", url=" + url + ", auditBySecretary=" + auditBySecretary + "]";
	}

}
