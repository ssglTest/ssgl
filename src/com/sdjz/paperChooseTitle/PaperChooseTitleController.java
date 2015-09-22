package com.sdjz.paperChooseTitle;

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
import com.sdjz.domain.PaperChooseTitle;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperChooseTitleService;

@Controller
@RequestMapping("userContro/paperChooseTitle")
public class PaperChooseTitleController {

	@Autowired
	private PaperChooseTitleService paperChooseTitleService;
	@RequestMapping("/paperChooseTitleManag.html")
	public String paperChooseTitleManager(HttpSession session,ModelMap modelMap){
		//Actor actor = CommonHelp.getCurrentActor(session);
		List<PaperChooseTitle> paperChooseTitleList = paperChooseTitleService.findAll();
		modelMap.put("paperChooseTitleList", paperChooseTitleList);
		return null;
	}
	
	@RequestMapping("/paperChooseTitleUpload.html")
	public String paperChooseTitleUpload(HttpServletRequest request, HttpServletResponse response, HttpSession session,
			MultipartFile paperChooseTitleFile,ModelMap modelMap) {
		//CommonHelp.upload(paperChooseTitleFile, session, "paperChooseTitle", "");
		Actor actor = CommonHelp.getCurrentActor(session);
		//paperChooseTitleService.findByNo(actor);
		PaperChooseTitle paperChooseTitle = null;
		return null;
	}

}
