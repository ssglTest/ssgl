package com.sdjz.paperChooseTitle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userContro/paperChooseTitle")
public class PaperChooseTitleController {

	@RequestMapping("paperChooseTitleUpload")
	public String paperChooseTitleUpload(HttpServletRequest request,HttpServletResponse response,HttpSession session){
		
		return null;
	}
	
}
