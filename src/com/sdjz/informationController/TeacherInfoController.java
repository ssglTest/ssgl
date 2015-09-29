package com.sdjz.informationController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdjz.domain.Teacher;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.TeacherService;

@Controller
@RequestMapping("userContro")
public class TeacherInfoController {
	@Autowired
	TeacherService teacherService;

	@RequestMapping(value = "/teacherInfo.html")
	public String queryInfo(HttpSession httpSession, ModelMap modelMap) {
		Teacher teacher = (Teacher) CommonHelp.getCurrentActor(httpSession);
		// 通过当前用户的id，在数据库中重新获取数据，这样可以避免重新点击链接，数据又恢复到原来的数据
		modelMap.put("teacher", teacherService.findById(teacher.getId()));
		return "userInformation/teacherInfo";
	}

	@RequestMapping(value = "/updateTeacherInfo.html", method = RequestMethod.POST)
	public String updateInfo(ModelMap modelMap, @RequestParam("email") String email,
			@RequestParam("mobile") String mobile, @RequestParam("qq") String qq,
			@RequestParam("teacherId") Integer id) {
		Teacher teacher = teacherService.findById(id);
		teacher.setEmail(email);
		teacher.setMobile(mobile);
		teacher.setQq(qq);
		teacherService.update(teacher);
		teacherService.save(teacher);
		modelMap.put("teacher", teacher);
		return "userInformation/teacherInfo";
	}

}
