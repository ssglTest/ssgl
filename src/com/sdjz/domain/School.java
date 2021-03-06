package com.sdjz.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@Table(name = "school")
@DynamicInsert(true)
@DynamicUpdate(true)
public class School implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(length = 20)
	private String description;
	@OneToMany(mappedBy = "school")
	private List<Student> students;
	@OneToMany(mappedBy = "school")
	private List<Tutor> tutors;
	@OneToMany(mappedBy = "school")
	private List<Major> majors;
	@OneToOne(mappedBy = "school")
	private Secretary secretary;
	@OneToMany(mappedBy = "school")
	private List<Teacher> teachers;

	@OneToMany(mappedBy = "school") // 论文选题申请
	private List<PaperTitleApply> paperTitleApplies;
	@OneToMany(mappedBy = "school") // 论文选题答辩
	private List<PaperTitleReply> paperTitleReplies;
	@OneToMany(mappedBy = "school") // 论文选题报告
	private List<PaperTitleReport> paperTitleReports;
	@OneToMany(mappedBy = "school") // 学术论文考核记录
	private List<SciencePaperCheck> sciencePaperChecks;
	@OneToMany(mappedBy="school")//学位论文答辩申请书
	private List<PaperReplyApply> paperReplyApplies;
	@OneToMany(mappedBy="school")//论文电子版
	private List<PaperElectronicEdition> paperElectronicEditions;
	@OneToMany(mappedBy="school")//硕士学位审批表
	private List<MasterDegreeAudit> masterDegreeAudits;
	@OneToMany(mappedBy="school")//期中检查表 
	private List<MidtermCheck> midtermChecks;
	@OneToMany(mappedBy="school")//学位论文答辩通知
	private List<PaperReplyNotifiCation> paperReplyNotifiCations;
	

	public School() {
	}

	public School(String description) {
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@XmlTransient
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@XmlTransient
	public List<Tutor> getTutors() {
		return tutors;
	}

	public void setTutors(List<Tutor> tutors) {
		this.tutors = tutors;
	}

	@XmlTransient
	public List<Major> getMajors() {
		return majors;
	}

	public void setMajors(List<Major> majors) {
		this.majors = majors;
	}

	public Secretary getSecretary() {
		return secretary;
	}

	public void setSecretary(Secretary secretary) {
		this.secretary = secretary;
	}

	@XmlTransient
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
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
