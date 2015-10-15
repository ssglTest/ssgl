package com.sdjz.paperTitleReport;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.PaperTitleApply;
import com.sdjz.domain.PaperTitleReport;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperTitleReportService;

@Controller
@RequestMapping("userContro/paperTitleReport")
public class PaperTitleReportController {

	@Autowired
	private PaperTitleReportService paperTitleReportService;

	/**
	 * 得到当前学生的论文选题报告和工作计划
	 * @param modelMap
	 * @param httpSession
	 * @return
	 */
	@RequestMapping("/getPaperTitleReportByStudent.html")
	public String getPaperTitleReportByStudent(ModelMap modelMap, HttpSession httpSession) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		PaperTitleApply paperTitleApply =student.getPaperTitleApply();
		if(paperTitleApply==null)
			return "warning/error";
		String approve = paperTitleApply.getApprove();
		if(approve.equals("notApproved"))
			return "warning/error";
		PaperTitleReport paperTitleReport = student.getPaperTitleReport();
		modelMap.put("paperTitleReport", paperTitleReport);
		return "paperTitleReport/paperTitleReportByStudent";
	}

	/**
	 * 根据研究生秘书，列出所有学生的论文选题报告和工作计划
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/paperTitleReportList.html")
	public String paperTitleReportList(ModelMap modelMap){
		List<PaperTitleReport> paperTitleReportList = paperTitleReportService.findAll();
		modelMap.put("paperTitleReportList", paperTitleReportList);
		return "paperTitleReport/paperTitleReportListBySecretary";
	}
	
	/**
	 * 学生上传论文选题报告和工作计划
	 * @param paperTitleReportFile
	 * @param httpSession
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/paperTitleReportUpdate.html")
	public String paperTitleReportUpdate(
			@RequestParam(value = "paperTitleReportFile") MultipartFile paperTitleReportFile, HttpSession httpSession,
			ModelMap modelMap) {
		PaperTitleReport paperTitleReport = null;
		if (paperTitleReportFile == null) {
			String info = "请选择文件！";
			modelMap.put("info", info);
			return "paperTitleReport/paperTitleReportByStudent";
		}
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		paperTitleReport = paperTitleReportService.findById(student.getId());
		if (paperTitleReport == null) {
			paperTitleReport = new PaperTitleReport();
			student.setPaperTitleReport(paperTitleReport);
			/*
			 * student.setPaperTitleReport(newPpaperTitleReport);
			 * paperTitleReport.setStudent(student);
			 */
		} else {
			CommonHelp.delete(httpSession, paperTitleReport.getUrl());
		}
		String folderName = "paperTitleReport";
		String url = CommonHelp.upload(paperTitleReportFile, httpSession, folderName, student.getId());
		String title = paperTitleReportFile.getOriginalFilename();
		paperTitleReport.setUpdateDate(CommonHelp.getCurrentDate());
		paperTitleReport.setUrl(url);
		paperTitleReport.setTitle(title);
		paperTitleReport.setStudent(student);
		paperTitleReportService.save(paperTitleReport);
		paperTitleReport = paperTitleReportService.findById(student.getId());
		String info = "文件上传成功";
		PaperTitleReport getPaperTitleReport = student.getPaperTitleReport();
		modelMap.put("paperTitleReport", getPaperTitleReport);
		modelMap.put("info", info);
		return "paperTitleReport/paperTitleReportByStudent";
	}

	/**
	 * 下载论文选题报告和工作计划
	 * @param httpSession
	 * @param paperTitleReportId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/paperTitleReportDownload.html")
	public ResponseEntity<byte[]> paperTitleReportDownload(HttpSession httpSession, Integer paperTitleReportId)
			throws IOException {
		PaperTitleReport paperTitleReport = paperTitleReportService.findById(paperTitleReportId);
		String name = "论文选题报告";
		return CommonHelp.download(httpSession, paperTitleReport.getUrl(), name);
	}
	
	/**
	 * 审核通过的controller
	 * @param paperTitleReportId jsp页面中传过来的论文选题报告的id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/approvedPaperTitleReport.html")
	public String approvedPaperTitleReport(Integer paperTitleReportId,ModelMap modelMap){
		PaperTitleReport paperTitleReport = paperTitleReportService.findById(paperTitleReportId);
		paperTitleReport.setApprove("approved");
		String date = CommonHelp.getCurrentDate();
		paperTitleReport.setAuditDate(date);
		paperTitleReportService.update(paperTitleReport);
		paperTitleReportService.save(paperTitleReport);
		List<PaperTitleReport> paperTitleReportList = paperTitleReportService.findAll();
		modelMap.put("paperTitleReportList", paperTitleReportList);
		return "paperTitleReport/paperTitleReportListBySecretary";
	}
	/**
	 * 审核未通过的controller
	 * @param paperTitleReportId jsp页面传过来的论文选题报告的id
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/notApprovedPaperTitleReport.html")
	public String notApprovedPaperTitleReport(Integer paperTitleReportId,ModelMap modelMap){
		PaperTitleReport paperTitleReport = paperTitleReportService.findById(paperTitleReportId);
		paperTitleReport.setApprove("notApproved");
		String date = CommonHelp.getCurrentDate();
		paperTitleReport.setAuditDate(date);
		paperTitleReportService.update(paperTitleReport);
		paperTitleReportService.save(paperTitleReport);
		List<PaperTitleReport> paperTitleReportList = paperTitleReportService.findAll();
		modelMap.put("paperTitleReportList", paperTitleReportList);
		return "paperTitleReport/paperTitleReportListBySecretary";
	}
}
