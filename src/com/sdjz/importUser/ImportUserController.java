package com.sdjz.importUser;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.domain.Teacher;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.SecretaryService;

@Controller
@RequestMapping("userContro/importUser")
public class ImportUserController {

	@Autowired
	private SecretaryService secretaryService;

	@RequestMapping("/importStudent.html")
	public String importStudent(HttpSession httpSession, ModelMap modelMap) {
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		List<Student> studentList = secretary.getSchool().getStudents();
		modelMap.put("studentList", studentList);
		return "importUser/importStudent";
	}

	@RequestMapping("/importTeacher.html")
	public String importTeacher(HttpSession httpSession, ModelMap modelMap) {
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		List<Teacher> teacherList = secretary.getSchool().getTeachers();
		modelMap.put("teacherList", teacherList);
		return "importUser/importTeacher";
	}
	
	@RequestMapping("/importStudentFromExcel.html")
	public String importStudentFromExcel(){
		return null;
	}
	
	@RequestMapping("/importTeacherFromExcel.html")
	public String importTeacherFromExcel(){
		return null;
	}

}
