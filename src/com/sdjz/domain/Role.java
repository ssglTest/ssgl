package com.sdjz.domain;


import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;



@Entity
@Table(name="role")
@DynamicInsert(true)
@DynamicUpdate(true)
public class Role implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String no;
	private String description;
	private String roleName;
	
	@OneToMany(mappedBy = "role",cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	private List<UserRole> userRoles;
	@OneToMany(mappedBy = "role",cascade = CascadeType.REFRESH)
	private Collection<RoleResource> roleResources;

	
	public Role(){}
	public Role(String description){
		this.description=description;
	}
	public Role(String no,String description){
		this.no=no;
		this.description=description;
	}
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
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@XmlTransient
	public List<UserRole> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}
	public Collection<RoleResource> getRoleResources() {
		return roleResources;
	}
	public void setRoleResources(Collection<RoleResource> roleResources) {
		this.roleResources = roleResources;
	}
	
	
	

}
