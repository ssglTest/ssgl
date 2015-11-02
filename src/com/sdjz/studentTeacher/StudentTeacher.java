package com.sdjz.studentTeacher;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.StudentService;

@Controller
@RequestMapping("userContro/studentTeacher")
public class StudentTeacher {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/getStudentTeacher.html")
	public String getStudentTeacher(HttpSession httpSession, ModelMap modelMap) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		student = studentService.findByNo(student.getNo());
		return null;
	}
}
