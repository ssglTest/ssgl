package com.sdjz.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "student")
public class Student extends Actor {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JoinColumn(name = "tutor_id")
	private Tutor tutor;
	@ManyToOne
	@JoinColumn(name = "school_id")
	private School school;
	@ManyToOne
	@JoinColumn(name = "major_id")
	private Major major;
	@ManyToMany
	@JoinTable(name = "student_teacher")
	private List<Teacher> teachers;
	@OneToOne(mappedBy = "student") // 论文选题申请
	private PaperTitleApply paperTitleApply;
	@OneToOne(mappedBy = "student") // 论文选题答辩
	private PaperTitleReply paperTitleReply;
	@OneToOne(mappedBy = "student") // 论文选题报告
	private PaperTitleReport paperTitleReport;
	@OneToOne(mappedBy = "student") // 学术论文考核记录
	private SciencePaperCheck sciencePaperCheck;
	@OneToOne(mappedBy = "student") // 中期检查表
	private MidtermCheck midtermCheck;
	@OneToOne(mappedBy = "student") // 学位论文答辩申请书
	private PaperReplyApply paperReplyApply;
	@OneToOne(mappedBy = "student") // 学位论文电子版
	private PaperElectronicEdition paperElectronicEdition;
	@OneToOne(mappedBy = "student") // 学位论文答辩成绩
	private PaperReplyGrade paperReplyGrade;
	@OneToOne(mappedBy = "student") // 硕士学位审批表
	private MasterDegreeAudit masterDegreeAudit;

	public Student() {
	}

	public Student(String no, String name) {
		super(no, name);
	}

	@XmlTransient
	public Tutor getTutor() {
		return tutor;
	}

	public void setTutor(Tutor tutor) {
		this.tutor = tutor;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Major getMajor() {
		return major;
	}

	public void setMajor(Major major) {
		this.major = major;
	}

	@XmlTransient
	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public PaperTitleApply getPaperTitleApply() {
		return paperTitleApply;
	}

	public void setPaperTitleApply(PaperTitleApply paperTitleApply) {
		this.paperTitleApply = paperTitleApply;
	}

	public PaperTitleReply getPaperTitleReply() {
		return paperTitleReply;
	}

	public void setPaperTitleReply(PaperTitleReply paperTitleReply) {
		this.paperTitleReply = paperTitleReply;
	}

	public PaperTitleReport getPaperTitleReport() {
		return paperTitleReport;
	}

	public void setPaperTitleReport(PaperTitleReport paperTitleReport) {
		this.paperTitleReport = paperTitleReport;
	}

	public SciencePaperCheck getSciencePaperCheck() {
		return sciencePaperCheck;
	}

	public void setSciencePaperCheck(SciencePaperCheck sciencePaperCheck) {
		this.sciencePaperCheck = sciencePaperCheck;
	}

	public MidtermCheck getMidtermCheck() {
		return midtermCheck;
	}

	public void setMidtermCheck(MidtermCheck midtermCheck) {
		this.midtermCheck = midtermCheck;
	}

	public PaperReplyApply getPaperReplyApply() {
		return paperReplyApply;
	}

	public void setPaperReplyApply(PaperReplyApply paperReplyApply) {
		this.paperReplyApply = paperReplyApply;
	}

	public PaperElectronicEdition getPaperElectronicEdition() {
		return paperElectronicEdition;
	}

	public void setPaperElectronicEdition(PaperElectronicEdition paperElectronicEdition) {
		this.paperElectronicEdition = paperElectronicEdition;
	}

	public PaperReplyGrade getPaperReplyGrade() {
		return paperReplyGrade;
	}

	public void setPaperReplyGrade(PaperReplyGrade paperReplyGrade) {
		this.paperReplyGrade = paperReplyGrade;
	}

	public MasterDegreeAudit getMasterDegreeAudit() {
		return masterDegreeAudit;
	}

	public void setMasterDegreeAudit(MasterDegreeAudit masterDegreeAudit) {
		this.masterDegreeAudit = masterDegreeAudit;
	}

}
