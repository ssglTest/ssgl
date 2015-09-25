package com.sdjz.paperTitleApply;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.Actor;
import com.sdjz.domain.PaperTitleApply;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperTitleApplyService;

@Controller
@RequestMapping("userContro/paperTitleApply")
public class PaperTitleApplyController {

	@Autowired
	private PaperTitleApplyService paperTitleApplyService;
	@RequestMapping("/paperTitleApplyManage.html")
	/**
	 * 列出所有的论文选题申请表
	 * @param session
	 * @param modelMap
	 * @return
	 */
	public String paperTitleApplyManager(HttpSession session,ModelMap modelMap){
		//Actor actor = CommonHelp.getCurrentActor(session);
		List<PaperTitleApply> paperTitleApplyList = paperTitleApplyService.findAll();
		modelMap.put("paperTitleApplyList", paperTitleApplyList);
		return "paperTitleApply/paperTitleApplyList";
	}
	
	@RequestMapping("/paperChooseTitleUpload.html")
	public String paperChooseTitleUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			MultipartFile paperChooseTitleFile,ModelMap modelMap) {
		//CommonHelp.upload(paperChooseTitleFile, session, "paperChooseTitle", "");
		Actor actor = CommonHelp.getCurrentActor(session);
		//paperChooseTitleService.findByNo(actor);
		PaperTitleApply paperChooseTitle = null;
		return null;
	}

}
