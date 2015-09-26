package com.sdjz.paperTitleApply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.PaperTitleApply;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperTitleApplyService;

@Controller
@RequestMapping("userContro/paperTitleApply")
public class PaperTitleApplyController {

	@Autowired
	private PaperTitleApplyService paperTitleApplyService;

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

	@RequestMapping("/paperTitleApplyManage.html")
	/**
	 * 列出所有的论文选题申请表
	 * 
	 * @param session
	 * @param modelMap
	 * @return
	 */
	public String paperTitleApplyManager(HttpSession session, ModelMap modelMap) {
		List<PaperTitleApply> paperTitleApplyList = paperTitleApplyService.findAll();
		modelMap.put("paperTitleApplyList", paperTitleApplyList);
		return "paperTitleApply/paperTitleApplyList";
	}

	@RequestMapping(value = "/paperTitleApplyUpload.html", method = RequestMethod.POST)
	public String paperChooseTitleUpload(HttpServletRequest request, HttpServletResponse response,
			HttpSession httpSession, @RequestParam("paperTitleApplyUpdate") MultipartFile paperTitleApplyUpdate,
			ModelMap modelMap) {
		PaperTitleApply paperTitleApply = null;
		if (paperTitleApplyUpdate == null) {
			modelMap.put("info", "请选择文件！");
			return "paperTitleApply/paperTitleApplyListByStudent";
		}
		// 判断该学生是否已经上传论文选题申请
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
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
			// paperTitleApplyService.save(paperTitleApply);
		}
		String folerName = "paperTitleApplyDoc";
		String url = CommonHelp.upload(paperTitleApplyUpdate, httpSession, folerName, student.getId());
		String title = paperTitleApplyUpdate.getName();
		System.out.println("==========title======="+title);
		paperTitleApply.setUrl(url);
		paperTitleApply.setTitle(title);
		paperTitleApplyService.update(paperTitleApply);
		System.out.println(paperTitleApply + "--------update paperTitleApply");
		// 重新获取论文选题申请表
		paperTitleApplyService.save(paperTitleApply);
		PaperTitleApply paper = student.getPaperTitleApply();
		modelMap.put("info", "文件上传成功");
		modelMap.put("paperTitleApply", paper);
		return "paperTitleApply/paperTitleApplyListByStudent";
	}

}
