package com.sdjz.informationController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.StudentService;

@Controller
@RequestMapping("userContro")
public class StudentInfoController {
	@Autowired
	StudentService studentService;
	@RequestMapping(value="/studentInfo.html",method=RequestMethod.GET)
	public String queryInfo(HttpSession httpSession,ModelMap modelMap){
		//获取当前用户：学生
		Student student=(Student)CommonHelp.getCurrentActor(httpSession);
		//modelMap.put("message","success");
		modelMap.put("student",student);
		return "userInformation/studentInfo" ;
	}
	
	@RequestMapping(value="/updateStudentInfo.html",method=RequestMethod.POST)
	public String updateInfo(ModelMap modelMap,@RequestParam("email")String email,@RequestParam("mobile")String mobile,@RequestParam("qq")String qq,@RequestParam("studentId")Integer studentId){
		Student student =studentService.findById(studentId);
		student.setEmail(email);
		student.setMobile(mobile);
		student.setQq(qq);
		studentService.update(student);
		modelMap.put("student",student);
		return "userInformation/studentInfo";
	}

}
