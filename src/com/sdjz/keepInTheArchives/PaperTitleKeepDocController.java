package com.sdjz.keepInTheArchives;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdjz.domain.Student;
import com.sdjz.service.StudentService;

@Controller
@RequestMapping("userContro/paperTitleKeepDoc")
public class PaperTitleKeepDocController {

	@Autowired
	private StudentService studentService;
	@RequestMapping("/paperTitleDocList.html")
	public String paperTitleDocList(ModelMap modelMap){
		List<Student> studentList = studentService.findAll();
		modelMap.put("studentList", studentList);
		return "keepInTheArchives/paperTitleKeepDoc";
	}
	
	@RequestMapping("/listPaperTitleDocByStudent.html")
	public String listPaperTitleDocByStudent(ModelMap modelMap,Integer studentId){
		System.out.println("studentId======="+studentId);
		return "keepInTheArchives/listPaperTitleDocByStudent";
	}
}
