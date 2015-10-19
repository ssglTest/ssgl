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
	@OneToMany(mappedBy = "school") // 学位论文答辩申请书
	private List<PaperReplyApply> paperReplyApply;
	@OneToMany(mappedBy = "school") // 学位论文电子版
	private List<PaperElectronicEdition> paperElectronicEdition;
	@OneToMany(mappedBy = "school") // 学位论文答辩时间地点
	private List<PaperReplyNotifiCation> paperReplyNotifiCation;
	@OneToMany(mappedBy = "school") // 学位论文答辩成绩
	private List<PaperReplyGrade> paperReplyGrade;
	@OneToMany(mappedBy = "school") // 硕士学位审批表
	private List<MasterDegreeAudit> masterDegreeAudit;

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
