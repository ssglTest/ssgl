package com.sdjz.paperTitleReply;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.PaperTitleReply;
import com.sdjz.domain.PaperTitleReport;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperTitleReplyService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;

@Controller
// paperTitleReplyTime/paperTitleReplyTimeList
@RequestMapping("userContro/paperTitleReply")
public class PaperTitleReplyController {

	@Autowired
	private PaperTitleReplyService paperTitleReplyService;
	@Autowired
	private SecretaryService secretaryService;
	@Autowired
	private StudentService studentService;

	@RequestMapping("/paperTitleReplyList.html")
	public String paperTitleReplyList(ModelMap modelMap, HttpSession httpSession) {
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		List<PaperTitleReply> paperTitleReplyList = secretary.getSchool().getPaperTitleReplies();
		modelMap.put("paperTitleReplyList", paperTitleReplyList);
		return "paperTitleReply/paperTitleReplyList";
	}

	@RequestMapping("/paperTitleReplyListByStudent.html")
	public String paperTitleReplyListByStudent(HttpSession httpSession, ModelMap modelMap) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		student = studentService.findByNo(student.getNo());
		List<PaperTitleReply> paperTitleReplyListByStudent = student.getSchool().getPaperTitleReplies();
		modelMap.put("paperTitleReplyList", paperTitleReplyListByStudent);
		return "paperTitleReply/paperTitleReplyListByStudent";
	}

	/**
	 * 研究生秘书上传学位论文选题报告的答辩时间地点 上传之后的文件允许有多个
	 * 
	 * @param httpSession
	 * @param modelMap
	 * @param paperTitleReplyFile
	 * @return
	 */
	@RequestMapping(value = "/paperTitleApplyUpload.html", method = RequestMethod.POST)
	public String updatePaperTitleReplyTime(HttpSession httpSession, ModelMap modelMap,
			@RequestParam(value = "paperTitleReplyFile") MultipartFile paperTitleReplyFile) {
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		if (paperTitleReplyFile == null) {
			String info = "请选择文件！";
			modelMap.put("info", info);
			return "paperTitleReply/paperTitleReplyList";
		}
		// List<PaperTitleReply> paperTitleReplyList =
		// paperTitleReplyService.findAll();
		// if (paperTitleReplyList.isEmpty()) {
		PaperTitleReply paperTitleReply = new PaperTitleReply();
		// }
		String folder = "paperTitleReplyDoc";
		String url = CommonHelp.upload(paperTitleReplyFile, httpSession, folder);
		String title = paperTitleReplyFile.getOriginalFilename();
		// Calendar date = CommonHelp.getNow();
		Integer day = CommonHelp.getDay();
		Integer month = CommonHelp.getMonth() + 1;
		Integer year = CommonHelp.getYear();
		String date = day + "/" + month + "/" + year;
		paperTitleReply.setTitle(title);
		paperTitleReply.setUrl(url);
		paperTitleReply.setUpdateDate(date);
		paperTitleReply.setSchool(secretary.getSchool());
		paperTitleReplyService.update(paperTitleReply);
		// 重新获取
		secretary = secretaryService.findByNo(secretary.getNo());
		List<PaperTitleReply> paperPaperTitleReply = secretary.getSchool().getPaperTitleReplies();
		String info = "上传成功！";
		modelMap.put("paperTitleReplyList", paperPaperTitleReply);
		modelMap.put("info", info);
		return "paperTitleReply/paperTitleReplyList";
	}

	@RequestMapping("/downloadPaperTitleReply.html")
	public ResponseEntity<byte[]> downloadPaperTitleReply(HttpSession httpSession, Integer paperTitleReplyId)
			throws IOException {
		PaperTitleReply paperTitleReply = paperTitleReplyService.findById(paperTitleReplyId);
		String name = "学位论文选题报告";
		return CommonHelp.download(httpSession, paperTitleReply.getUrl(), name);
	}

	@RequestMapping("/paperTitleReplyGrade.html")
	public String paperTitleReplyGrade(ModelMap modelMap, HttpSession httpSession) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		PaperTitleReport paperTitleReport = student.getPaperTitleReport();
		modelMap.put("paperTitleReport", paperTitleReport);
		return "paperTitleReply/paperTitleReplyGrade";
	}

}
