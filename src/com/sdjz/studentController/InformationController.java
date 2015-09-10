package com.sdjz.studentController;

import java.util.Map;
import javax.servlet.http.HttpSession;
import javax.swing.text.html.FormSubmitEvent.MethodType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sdjz.domain.Student;
import com.sdjz.other.CommonHelper;

@Controller
public class InformationController {
	
	@RequestMapping(value="userContro/queryInfo.html")
	public String  queryInfo(HttpSession httpSession,ModelMap modelMap){
		//获取当前学生
		Student student=(Student)CommonHelper.getCurrentActor(httpSession);
		modelMap.put("student",student);
		modelMap.put("message","跳转成功");
		return "information/student";
	}
	@RequestMapping(value="userContro/updateInfo.html",method=RequestMethod.GET)
	public String updateInfo(HttpSession httpSession,ModelMap modelMap){
		//获取当前学生
		Student student=(Student)CommonHelper.getCurrentActor(httpSession);
		modelMap.put("student",student);
		return "information/updateStudent";
	}
	@RequestMapping(value="userContro/updateInfo.html",method=RequestMethod.POST)
	public String updateInfo(ModelMap modelMap,Integer id,String email,String qq,String mobile){
		
		return "information/student";
	}
	
	

}
