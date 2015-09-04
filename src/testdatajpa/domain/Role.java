package testdatajpa.domain;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(length=5)
	private Integer roleIndex;
	@Column(length=5)
	private String description;
	@ManyToMany
	@JoinTable(name="user_role")
	private List<User> users;
	public Role(){}
	public Role(String description){
		this.description=description;
	}
	public Role(Integer roleIndex,String description){
		this.roleIndex=roleIndex;
		this.description=description;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRoleIndex() {
		return roleIndex;
	}
	public void setRoleIndex(Integer roleIndex) {
		this.roleIndex = roleIndex;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<User> getUsers() {
		return users;
	}
	public void setUsers(List<User> users) {
		this.users = users;
	}
	
	
	
	

}
