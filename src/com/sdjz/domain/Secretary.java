package com.sdjz.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;

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
	
	@OneToMany(mappedBy="secretary")//论文选题申请
	private List<PaperTitleApply> paperTitleApplies;
	@OneToMany(mappedBy="secretary")//论文选题答辩
	private List<PaperTitleReply> paperTitleReplies;
	@OneToMany(mappedBy="secretary")//论文选题报告
	private List<PaperTitleReport> paperTitleReports;
	@OneToMany(mappedBy="secretary")//学术论文考核记录
	private List<SciencePaperCheck> sciencePaperChecks;
	
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
	@XmlTransient
	public List<PaperTitleApply> getPaperTitleApplies() {
		return paperTitleApplies;
	}
	public void setPaperTitleApplies(List<PaperTitleApply> paperTitleApplies) {
		this.paperTitleApplies = paperTitleApplies;
	}
	@XmlTransient
	public List<PaperTitleReply> getPaperTitleReplies() {
		return paperTitleReplies;
	}
	public void setPaperTitleReplies(List<PaperTitleReply> paperTitleReplies) {
		this.paperTitleReplies = paperTitleReplies;
	}
	@XmlTransient
	public List<PaperTitleReport> getPaperTitleReports() {
		return paperTitleReports;
	}
	public void setPaperTitleReports(List<PaperTitleReport> paperTitleReports) {
		this.paperTitleReports = paperTitleReports;
	}
	@XmlTransient
	public List<SciencePaperCheck> getSciencePaperChecks() {
		return sciencePaperChecks;
	}
	public void setSciencePaperChecks(List<SciencePaperCheck> sciencePaperChecks) {
		this.sciencePaperChecks = sciencePaperChecks;
	}
	
	
	

}
