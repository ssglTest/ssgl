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
	@OneToMany(mappedBy = "secretary") // 学位论文答辩申请书
	private List<PaperReplyApply> paperReplyApply;
	@OneToMany(mappedBy = "secretary") // 学位论文电子版
	private List<PaperElectronicEdition> paperElectronicEdition;
	@OneToMany(mappedBy = "secretary") // 学位论文答辩时间地点
	private List<PaperReplyNotifiCation> paperReplyNotifiCation;
	@OneToMany(mappedBy = "secretary") // 学位论文答辩成绩
	private List<PaperReplyGrade> paperReplyGrade;
	@OneToMany(mappedBy = "secretary") // 硕士学位审批表
	private List<MasterDegreeAudit> masterDegreeAudit;

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
	public List<PaperReplyApply> getPaperReplyApply() {
		return paperReplyApply;
	}

	public void setPaperReplyApply(List<PaperReplyApply> paperReplyApply) {
		this.paperReplyApply = paperReplyApply;
	}

	@XmlTransient
	public List<PaperElectronicEdition> getPaperElectronicEdition() {
		return paperElectronicEdition;
	}

	public void setPaperElectronicEdition(List<PaperElectronicEdition> paperElectronicEdition) {
		this.paperElectronicEdition = paperElectronicEdition;
	}

	@XmlTransient
	public List<PaperReplyNotifiCation> getPaperReplyNotifiCation() {
		return paperReplyNotifiCation;
	}

	public void setPaperReplyNotifiCation(List<PaperReplyNotifiCation> paperReplyNotifiCation) {
		this.paperReplyNotifiCation = paperReplyNotifiCation;
	}

	@XmlTransient
	public List<PaperReplyGrade> getPaperReplyGrade() {
		return paperReplyGrade;
	}

	public void setPaperReplyGrade(List<PaperReplyGrade> paperReplyGrade) {
		this.paperReplyGrade = paperReplyGrade;
	}

	@XmlTransient
	public List<MasterDegreeAudit> getMasterDegreeAudit() {
		return masterDegreeAudit;
	}

	public void setMasterDegreeAudit(List<MasterDegreeAudit> masterDegreeAudit) {
		this.masterDegreeAudit = masterDegreeAudit;
	}

}
