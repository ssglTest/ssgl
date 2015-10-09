package com.sdjz.paperTitleReport;

import java.io.IOException;

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

	@RequestMapping("/getPaperTitleReportByStudent.html")
	public String getPaperTitleReportByStudent(ModelMap modelMap, HttpSession httpSession) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		PaperTitleApply paperTitleApply =student.getPaperTitleApply();
		String approve = paperTitleApply.getApprove();
		if(approve.equals("notApproved"))
			return "warning/error";
		PaperTitleReport paperTitleReport = paperTitleReportService.findById(student.getId());
		modelMap.put("paperTitleReport", paperTitleReport);
		return "paperTitleReport/paperTitleReportByStudent";
	}

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
		paperTitleReport.setDate(CommonHelp.getCurrentDate());
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

	@RequestMapping("/paperTitleReportDownload.html")
	public ResponseEntity<byte[]> paperTitleReportDownload(HttpSession httpSession, Integer paperTitleReportId)
			throws IOException {
		PaperTitleReport paperTitleReport = paperTitleReportService.findById(paperTitleReportId);
		String name = "论文选题报告";
		return CommonHelp.download(httpSession, paperTitleReport.getUrl(), name);
	}
}
