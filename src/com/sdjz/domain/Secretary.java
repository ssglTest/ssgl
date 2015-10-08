package com.sdjz.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.DynamicUpdate;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public class Secretary extends Actor{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name="school_id")
	private School school;
	
	@OneToMany(mappedBy="secretary")
	private List<PaperTitleApply> paperTitleApplies;
	
	@OneToMany(mappedBy="secretary")
	private List<PaperTitleReply> paperTitleReplies;
	
	public Secretary(){}
	public Secretary(String no,String name){
		super(no,name);		
	}
	public School getSchool() {
		return school;
	}
	public void setSchool(School school) {
		this.school = school;
	}
	public List<PaperTitleApply> getPaperTitleApplies() {
		return paperTitleApplies;
	}
	public void setPaperTitleApplies(List<PaperTitleApply> paperTitleApplies) {
		this.paperTitleApplies = paperTitleApplies;
	}
	public List<PaperTitleReply> getPaperTitleReplies() {
		return paperTitleReplies;
	}
	public void setPaperTitleReplies(List<PaperTitleReply> paperTitleReplies) {
		this.paperTitleReplies = paperTitleReplies;
	}
	
	

}
