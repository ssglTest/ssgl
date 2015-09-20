package com.sdjz.pageTestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userContro/secretary")
public class SecretaryControllerTest {

	@RequestMapping("/informationTest.html")
	public String informationTest(){
		return "secretaryTest/informationTest";
	}
	
	@RequestMapping("/chooseTitleName")
	public String chooseTitleName(){
		return "secretaryTest/chooseTitleName";
	}
	
	@RequestMapping("/lookChooseTitle.html")
	public String lookChooseTitle(){
		return "secretaryTest/lookChooseTitle";
	}
	
	@RequestMapping("/uploadChooseTitleReportTime.html")
	public String uploadChooseTitleReportTime(){
		return "secretaryTest/uploadChooseTitleReportTime";
	}
	
	@RequestMapping("/saveChooseTitle.html")
	public String saveChooseTitle(){
		return "secretaryTest/saveChooseTitle";
	}
	
	@RequestMapping("/copyCheck.html")
	public String copyCheck(){
		return "secretaryTest/copyCheck";
	}
	
	
}
