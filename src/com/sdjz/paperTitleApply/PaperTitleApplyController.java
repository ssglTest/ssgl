package com.sdjz.paperTitleApply;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.PaperTitleApply;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperTitleApplyService;
import com.sdjz.service.SecretaryService;

@Controller
@RequestMapping("userContro/paperTitleApply")
public class PaperTitleApplyController{

	@Autowired
	private PaperTitleApplyService paperTitleApplyService;
	@Autowired
	private SecretaryService secretaryService;

	/**
	 * 根据当前学生获取提交的论文选题申请表
	 * 
	 * @param httpSession
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/getPaperTitleApplyByStudent.html")
	public String getPaperTitleApplyByStudent(HttpSession httpSession, ModelMap modelMap) {
		// 获取当前学生
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		// 得到PaperTitleApply对象
		PaperTitleApply paperTitleApply = student.getPaperTitleApply();
		// 添加到modelMap中，在jsp中获取
		modelMap.put("paperTitleApply", paperTitleApply);
		return "paperTitleApply/paperTitleApplyListByStudent";
	}

	@RequestMapping(value = "/paperTitleApplyManage.html")
	/**
	 * 列出所有的论文选题申请表
	 * 
	 * @param session
	 * @param modelMap
	 * @return
	 */
	public String paperTitleApplyManager(HttpSession httpSession, ModelMap modelMap) {
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		List<PaperTitleApply> paperTitleApplyList = secretary.getSchool().getPaperTitleApplies();
		modelMap.put("paperTitleApplyList", paperTitleApplyList);
		return "paperTitleApply/paperTitleApplyList";
	}

	@RequestMapping(value = "/paperTitleApplyUpload.html", method = RequestMethod.POST)
	public String paperChooseTitleUpload(HttpServletRequest request, HttpServletResponse response,
			HttpSession httpSession,
			@RequestParam(value = "paperTitleApplyUpdate", required = false) MultipartFile paperTitleApplyUpdate,
			ModelMap modelMap) {
		PaperTitleApply paperTitleApply = null;
		// 判断点击提交时是否已经选择了文件
		if (paperTitleApplyUpdate == null) {
			modelMap.put("info", "请选择文件！");
			return "paperTitleApply/paperTitleApplyListByStudent";
		}
		// 得到当前学生
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		// 根据学生获取所上传的论文选题申请表
		paperTitleApply = student.getPaperTitleApply();
		if (paperTitleApply == null) {
			// 创建一个新的论文选题申请
			paperTitleApply = new PaperTitleApply();
			// 关联关系
			student.setPaperTitleApply(paperTitleApply);
			// 保存
			paperTitleApply.setStudent(student);

		} else {
			// 删除论文选题申请
			CommonHelp.delete(httpSession, paperTitleApply.getUrl());
		}
		String folerName = "paperTitleApplyDoc";
		// 得到文件上传的路径
		String url = CommonHelp.upload(paperTitleApplyUpdate, httpSession, folerName, student.getId());
		// 获取文件名
		String title = paperTitleApplyUpdate.getOriginalFilename();
		String date = CommonHelp.getCurrentDate();

		paperTitleApply.setUrl(url);
		paperTitleApply.setSchool(student.getSchool());
		paperTitleApply.setTitle(title);
		paperTitleApply.setUpdateDate(date);

		paperTitleApplyService.update(paperTitleApply);
		// 重新获取论文选题申请表
		PaperTitleApply paper = student.getPaperTitleApply();
		modelMap.put("info", "文件上传成功");
		modelMap.put("paperTitleApply", paper);
		return "paperTitleApply/paperTitleApplyListByStudent";
	}

	/**
	 * 下载论文选题申请表
	 * 
	 * @param httpSession
	 * @param paperTitleApplyId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/downPaperTitleApply.html")
	public ResponseEntity<byte[]> downPaperTitleApply(HttpSession httpSession, Integer paperTitleApplyId)
			throws IOException {
		PaperTitleApply paperTitleApply = paperTitleApplyService.findById(paperTitleApplyId);
		String name = "论文选题申请表";
		return CommonHelp.download(httpSession, paperTitleApply.getUrl(), name);
	}

	/**
	 * 审核通过后controller
	 * 
	 * @param modelMap
	 * @param paperTitleApplyId
	 *            从jsp页面传过来的论文选题申请表的id
	 * @return
	 */
	@RequestMapping("/approvedPaperTitleApply.html")
	public String approvedPaperTitleApply(HttpSession httpSession,ModelMap modelMap, Integer paperTitleApplyId) {
		System.out.println("已跳转到这个controller=============================");
		// 通过id找到当前的论文选题申请表
		PaperTitleApply paperTitleApply = paperTitleApplyService.findById(paperTitleApplyId);
		paperTitleApply.setApprove("approved");
		// 获取当前时间
		String date = CommonHelp.getCurrentDate();
		paperTitleApply.setAuditDate(date);
		// 更新数据库
		paperTitleApplyService.update(paperTitleApply);
		paperTitleApplyService.save(paperTitleApply);
		/*
		 * // 列出所有的选题申请表，重新刷新，这会影响性能！ List<PaperTitleApply> paperTitleApplyList
		 * = paperTitleApplyService.findAll();
		 * modelMap.put("paperTitleApplyList", paperTitleApplyList);
		 */
		// return "paperTitleApply/paperTitleApplyList";
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		List<PaperTitleApply> paperTitleApplyList = secretary.getSchool().getPaperTitleApplies();
		modelMap.put("paperTitleApplyList", paperTitleApplyList);
		return "paperTitleApply/paperTitleApplyList";
	}

	/**
	 * 审核没有通过后的controller
	 * 
	 * @param modelMap
	 * @param paperTitleApplyId
	 * @return
	 */
	@RequestMapping("/notApprovedPaperTitleApply.html")
	public String notApprovedPaperTitleApply(HttpSession httpSession,ModelMap modelMap, Integer paperTitleApplyId) {
		PaperTitleApply paperTitleApply = paperTitleApplyService.findById(paperTitleApplyId);
		paperTitleApply.setApprove("notApproved");
		// 获取当前时间
		String date = CommonHelp.getCurrentDate();
		paperTitleApply.setAuditDate(date);
		// 更新数据库
		paperTitleApplyService.update(paperTitleApply);
		paperTitleApplyService.save(paperTitleApply);
		// 列出所有的选题申请表，重新刷新，这会影响性能！
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		List<PaperTitleApply> paperTitleApplyList = secretary.getSchool().getPaperTitleApplies();
		modelMap.put("paperTitleApplyList", paperTitleApplyList);
		return "paperTitleApply/paperTitleApplyList";
	}
	
	@RequestMapping("/getApproved.html")
	public String getApproved(HttpSession httpSession,ModelMap modelMap){
		System.out.println("======================================================");
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		
		return "paperTitleApply/paperTitleApplyList";
	}
	
	@RequestMapping("/getNotApproved.html")
	public String getNotApproved(HttpSession httpSession,ModelMap modelmap){
		
		return null;
	}

}
