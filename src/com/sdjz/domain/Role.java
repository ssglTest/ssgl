package com.sdjz.domain;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
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

	@ManyToMany(mappedBy="roles")
	private List<User> users;
	@ManyToMany(mappedBy="roles")
	private List<Resource> resources=new ArrayList<Resource>();
	
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
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	@XmlTransient
	public List<Resource> getResources() {
		return resources;
	}
	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}
	
	public void addResource(Resource resource){
		this.resources.addAll(resources);
	}
	public void removeResource(Resource resource){
		if(this.resources.contains(resource)){
		this.resources.remove(resource);
		}
	}
	
	

}
