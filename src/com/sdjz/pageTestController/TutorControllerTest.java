package com.sdjz.pageTestController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("userContro/tutor")
public class TutorControllerTest {

	@RequestMapping("/myStudent.html")
	public String myStudent(){
		return "tutorTest/myStudent";
	}
}
