package com.sdjz.informationController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdjz.domain.Tutor;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.TutorService;

@Controller
@RequestMapping("userContro")
public class TutorInfoController {
	@Autowired
	TutorService tutorService;
	
	@RequestMapping(value="/tutorInfo.html")
	public String queryInfo(HttpSession httpSession,ModelMap modelMap){
		//获取当前用户：研究生导师
		Tutor tutor=(Tutor)CommonHelp.getCurrentActor(httpSession);
		modelMap.put("tutor",tutor);
		return "userInformation/tutorInfo";
	}
	
	@RequestMapping(value="/updateTutorInfo.html",method=RequestMethod.POST)
	public String updateInfo(ModelMap modelMap,@RequestParam("email")String email,@RequestParam("mobile")String mobile,@RequestParam("qq")String qq,@RequestParam("tutorId")Integer id){
		Tutor tutor=tutorService.findById(id);
		tutor.setEmail(email);
		tutor.setMobile(mobile);
		tutor.setQq(qq);
		tutorService.update(tutor);
		modelMap.put("tutor", tutor);
		return "userInformation/tutorInfo";
	}

}
