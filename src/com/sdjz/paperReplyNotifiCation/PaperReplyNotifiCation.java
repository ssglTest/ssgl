package com.sdjz.paperReplyNotifiCation;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.Secretary;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.SecretaryService;

@Controller
@RequestMapping("userContro/paperReplyNotifiCation")
public class PaperReplyNotifiCation {

	@Autowired
	private SecretaryService secretaryService;

	@RequestMapping("/paperReplyNotifiCationList.html")
	public String paperReplyNotifiCationList(ModelMap modelMap, HttpSession httpSession) {
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		// List<PaperReplyNotifiCation> paperReplyNotifiCation =
		// secretary.getPaperReplyNotifiCations();
		List<com.sdjz.domain.PaperReplyNotifiCation> paperReplyNotifiCationList = secretary
				.getPaperReplyNotifiCations();
		modelMap.put("paperReplyNotifiCationList", paperReplyNotifiCationList);
		return "paperReplyNotifiCation/paperReplyNotifiCationList";
	}

	public String updatePaperReplyNotifiCation(ModelMap modelMap, HttpSession httpSession,
			@RequestParam(value = "paperReplyNotifiCationFile", required = false) MultipartFile paperReplyNotifiCationFile) {
		
		return null;
	}

}
