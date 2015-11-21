package com.sdjz.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name="resource")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Resource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String no;
	private String rel;
	private String url;
	private String description;
	
	@OneToMany(mappedBy = "resource", cascade = CascadeType.ALL)
	private List<RoleResource> roleResources;
	@OneToMany(mappedBy = "parent", cascade = CascadeType.ALL)
	private List<Resource> child;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private Resource parent;
	
	public Resource(){}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getRel() {
		return rel;
	}

	public void setRel(String rel) {
		this.rel = rel;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RoleResource> getRoleResources() {
		return roleResources;
	}

	public void setRoleResources(List<RoleResource> roleResources) {
		this.roleResources = roleResources;
	}

	public List<Resource> getChild() {
		return child;
	}

	public void setChild(List<Resource> child) {
		this.child = child;
	}

	public Resource getParent() {
		return parent;
	}

	public void setParent(Resource parent) {
		this.parent = parent;
	}
	
	


}
