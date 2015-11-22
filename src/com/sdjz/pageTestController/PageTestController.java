package com.sdjz.pageTestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("test")
public class PageTestController {

	@RequestMapping("/publicClassInformation.html")
	public String publicClassInformation(){
		return "information/publicClassInformation";
	}
	
	@RequestMapping("/personalPlan.html")
	public String personalPlan(){
		return "information/personalPlan";
	}
	
	@RequestMapping("/projectChooseTitle.html")
	public String projectChooseTitle(){
		return "information/projectChooseTitle";
	}
	
	@RequestMapping("/chooseTitleReport.html")
	public String chooseTitleReport(){
		return "information/chooseTitleReport";
	}
	
	@RequestMapping("/chooseTitleAnswer.html")
	public String chooseTitleAnswer(){
		return "information/chooseTitleAnswer";
	}
	
	@RequestMapping("/checkMiddle.html")
	public String checkMiddle(){
		return "information/checkMiddle";
	}
	
	@RequestMapping("/postGraduateFileRlus.html")
	public String postGraduateFileRlus(){
		return "information/postGraduateFileRlus";
	}
	
	@RequestMapping("/needUpdateFile.html")
	public String needUpdateFile(){
		return "information/needUpdateFile";
	}
	
	@RequestMapping("/basicFlow.html")
	public String basicFlow(){
		return "information/basicFlow";
	}
	
	@RequestMapping("/notpass.html")
	public String notPass(){
		if(true){
			return "information/error";
		}
		return null;
	}
	
	@RequestMapping("/updatePaper.html")
	public String updatePaper(){
		return "information/updatePaper";
	}
}
