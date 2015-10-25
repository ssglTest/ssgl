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
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Secretary extends Actor {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@OneToOne
	@JoinColumn(name = "school_id")
	private School school;

	@OneToMany(mappedBy = "secretary") // 论文选题申请
	private List<PaperTitleApply> paperTitleApplies;
	@OneToMany(mappedBy = "secretary") // 论文选题答辩
	private List<PaperTitleReply> paperTitleReplies;
	@OneToMany(mappedBy = "secretary") // 论文选题报告
	private List<PaperTitleReport> paperTitleReports;
	@OneToMany(mappedBy = "secretary") // 学术论文考核记录
	private List<SciencePaperCheck> sciencePaperChecks;
	@OneToMany(mappedBy="secretary")//学位论文答辩申请
	private List<PaperReplyApply> paperReplyApplies;
	@OneToMany(mappedBy="secretary")//论文电子版
	private List<PaperElectronicEdition> paperElectronicEditions;
	@OneToMany(mappedBy="secretary")//硕士学位审批表
	private List<MasterDegreeAudit> masterDegreeAudits;
	@OneToMany(mappedBy="secretary")//期中检查表
	private List<MidtermCheck> midtermChecks;
	@OneToMany(mappedBy="secretary")//学位论文答辩通知
	private List<PaperReplyNotifiCation> paperReplyNotifiCations;
	
	public Secretary() {
	}

	public Secretary(String no, String name) {
		super(no, name);
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
	@XmlTransient
	public List<PaperReplyApply> getPaperReplyApplies() {
		return paperReplyApplies;
	}

	public void setPaperReplyApplies(List<PaperReplyApply> paperReplyApplies) {
		this.paperReplyApplies = paperReplyApplies;
	}
	@XmlTransient
	public List<PaperElectronicEdition> getPaperElectronicEditions() {
		return paperElectronicEditions;
	}

	public void setPaperElectronicEditions(List<PaperElectronicEdition> paperElectronicEditions) {
		this.paperElectronicEditions = paperElectronicEditions;
	}
	@XmlTransient
	public List<MasterDegreeAudit> getMasterDegreeAudits() {
		return masterDegreeAudits;
	}

	public void setMasterDegreeAudits(List<MasterDegreeAudit> masterDegreeAudits) {
		this.masterDegreeAudits = masterDegreeAudits;
	}
	@XmlTransient
	public List<MidtermCheck> getMidtermChecks() {
		return midtermChecks;
	}

	public void setMidtermChecks(List<MidtermCheck> midtermChecks) {
		this.midtermChecks = midtermChecks;
	}
	@XmlTransient
	public List<PaperReplyNotifiCation> getPaperReplyNotifiCations() {
		return paperReplyNotifiCations;
	}

	public void setPaperReplyNotifiCations(List<PaperReplyNotifiCation> paperReplyNotifiCations) {
		this.paperReplyNotifiCations = paperReplyNotifiCations;
	}
	
	
	
}
