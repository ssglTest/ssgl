package com.sdjz.paperReplyApply;

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

import com.sdjz.domain.PaperReplyApply;
import com.sdjz.domain.School;
import com.sdjz.domain.SciencePaperCheck;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperReplyApplyService;
import com.sdjz.service.SecretaryService;

@Controller
@RequestMapping("paperReplyApply")
public class PaperReplyApplyController {

	@Autowired
	private PaperReplyApplyService paperReplyApplyService;
	@Autowired
	private SecretaryService secretaryService;

	/*
	 * 研究生秘书获取学位论文答辩申请书
	 */
	@RequestMapping("/paperReplyApplyList.html")
	private String paperReplyApplyList(ModelMap modelMap, HttpSession httpSession) {
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		School school = secretary.getSchool();
		List<PaperReplyApply> paperReplyApplyList = school.getPaperReplyApplies();
		modelMap.put("paperReplyApplyList", paperReplyApplyList);
		return "paperReplyApply/paperReplyApplyList";
	}

	/*
	 * 学生获取学位论文答辩申请书
	 */
	@RequestMapping("/paperReplyApplyListByStudent.html")
	private String paperReplyApplyListByStudent(ModelMap modelMap, HttpSession httpSession) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		SciencePaperCheck sciencePaperCheck = student.getSciencePaperCheck();
		// 判断学术论文考核记录表是否通过
		if (sciencePaperCheck == null || sciencePaperCheck.getApprove() == "notApproved"
				|| sciencePaperCheck.getApprove() == null)
			return "warning/error";
		PaperReplyApply paperReplyApply = student.getPaperReplyApply();
		modelMap.put("paperReplyApply", paperReplyApply);
		return "paperReplyApply/paperReplyApplyListByStudent";
	}

	@RequestMapping("/updatePaperReplyApply.html")
	private String updatePaperReplyApply(ModelMap modelMap, HttpSession httpSession,
			@RequestParam(value = "paperReplyApplyFile", required = false) MultipartFile paperReplyApplyFile) {
		if (paperReplyApplyFile == null) {
			modelMap.put("info", "请选择文件！");
			return "paperReplyApply/paperReplyApplyListByStudent";
		}
		PaperReplyApply paperReplyApply = null;
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		paperReplyApply = student.getPaperReplyApply();
		if (paperReplyApply == null) {
			paperReplyApply = new PaperReplyApply();
		} else {
			CommonHelp.delete(httpSession, paperReplyApply.getUrl());
		}
		String folderName = "paperReplyApply";
		String fileName = "学位论文答辩申请书";
		String url = CommonHelp.upload(paperReplyApplyFile, httpSession, folderName, fileName);
		String updateDate = CommonHelp.getCurrentDate();
		paperReplyApply.setSchool(student.getSchool());
		paperReplyApply.setUrl(url);
		paperReplyApply.setUpdateDate(updateDate);
		paperReplyApply.setTitle(paperReplyApplyFile.getOriginalFilename());
		paperReplyApply.setStudent(student);
		paperReplyApplyService.update(paperReplyApply);
		PaperReplyApply pra = student.getPaperReplyApply();
		modelMap.put("paperReplyApply", pra);
		modelMap.put("info", "文件上传成功！");
		return "paperReplyApply/paperReplyApplyListByStudent";
	}

	/*
	 * 审核通过
	 */
	@RequestMapping("/approvedPaperReplyApply.html")
	public String approvedPaperReplyApply(ModelMap modelMap, Integer paperReplyApplyId) {
		PaperReplyApply paperReplyApply = paperReplyApplyService.findById(paperReplyApplyId);
		paperReplyApply.setApprove("approved");
		paperReplyApply.setAuditDate(CommonHelp.getCurrentDate());
		paperReplyApplyService.update(paperReplyApply);
		paperReplyApplyService.save(paperReplyApply);
		List<PaperReplyApply> pra = paperReplyApplyService.findAll();
		modelMap.put("paperReplyApplyList", pra);
		return "paperReplyApply/paperReplyApplyList";
	}

	/*
	 * 审核不通过
	 */
	@RequestMapping("/notApprovedPaperReplyApply.html")
	public String notApprovedPaperReplyApply(ModelMap modelMap, Integer paperReplyApplyId) {
		PaperReplyApply paperReplyApply = paperReplyApplyService.findById(paperReplyApplyId);
		paperReplyApply.setApprove("notApproved");
		paperReplyApply.setAuditDate(CommonHelp.getCurrentDate());
		paperReplyApplyService.update(paperReplyApply);
		paperReplyApplyService.save(paperReplyApply);
		List<PaperReplyApply> pra = paperReplyApplyService.findAll();
		modelMap.put("paperReplyApplyList", pra);
		return "paperReplyApply/paperReplyApplyList";
	}

	/*
	 * 下载
	 */
	@RequestMapping("/downPaperReplyApply.html")
	public ResponseEntity<byte[]> downPaperReplyApply(HttpSession httpSession, Integer paperReplyApplyId)
			throws IOException {
		PaperReplyApply paperReplyApply = paperReplyApplyService.findById(paperReplyApplyId);
		String name = "论文选题申请表";
		return CommonHelp.download(httpSession, paperReplyApply.getUrl(), name);
	}

}
