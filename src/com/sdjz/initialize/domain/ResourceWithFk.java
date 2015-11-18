package com.sdjz.initialize.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import com.sdjz.domain.RoleResource;

@Entity
@Table(name = "resource")
@DynamicInsert(true)
@DynamicUpdate(true)
public class ResourceWithFk implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String no;
	private String description;
	private Integer parentId;
	
	@OneToMany(mappedBy = "resource" , cascade = CascadeType.ALL)
	private List<RoleResource> roleResources;
	@OneToMany(mappedBy = "parent",cascade = CascadeType.ALL)
	private List<ResourceWithFk> child;
	@ManyToOne
	@JoinColumn(name = "parent_id")
	private ResourceWithFk parent;
	
	public ResourceWithFk(){}

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public List<RoleResource> getRoleResources() {
		return roleResources;
	}

	public void setRoleResources(List<RoleResource> roleResources) {
		this.roleResources = roleResources;
	}

	public List<ResourceWithFk> getChild() {
		return child;
	}

	public void setChild(List<ResourceWithFk> child) {
		this.child = child;
	}

	public ResourceWithFk getParent() {
		return parent;
	}

	public void setParent(ResourceWithFk parent) {
		this.parent = parent;
	}
	
	
	
	
	

}
