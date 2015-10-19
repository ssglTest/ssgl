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
 * 学位论文答辩时间地点
 * 
 * @author zhan
 *
 */
@Entity
@Table(name = "paperReplyNotifiCation")
@DynamicInsert(true)
@DynamicUpdate(true)
public class PaperReplyNotifiCation implements Serializable {

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
	private String url;
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;
	@ManyToOne
	@JoinColumn(name = "secretary_id")
	private Secretary secretary;

	public PaperReplyNotifiCation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PaperReplyNotifiCation(Integer id, String title, String updateDate, String url, School school,
			Secretary secretary) {
		super();
		this.id = id;
		this.title = title;
		this.updateDate = updateDate;
		this.url = url;
		this.school = school;
		this.secretary = secretary;
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
