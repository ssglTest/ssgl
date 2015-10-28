package com.sdjz.paperElectronicEdition;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.PaperElectronicEdition;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperElectronicEditionService;

@Controller
@RequestMapping("userContro/paperElectronicEdition")
public class PaperElectronicEditionController {

	@Autowired
	private PaperElectronicEditionService paperElectronicEditionService;

	@RequestMapping("/paperElectronicEditionListByStudent.html")
	public String paperElectronicEditionListByStudent(ModelMap modelMap, HttpSession httpSession) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		PaperElectronicEdition paperElectronicEdition = student.getPaperElectronicEdition();
		modelMap.put("paperElectronicEdition", paperElectronicEdition);
		return "paperElectronicEdition/paperElectronicEditionListByStudent";
	}

	@RequestMapping("/updatePaperElectronicEdition.html")
	public String update(ModelMap modelMap, HttpSession httpSession,
			@RequestParam(value = "paperElectronicEditionFile", required = false) MultipartFile paperElectronicEditionFile) {
		if(paperElectronicEditionFile==null){
			modelMap.put("info", "请选择文件！");
			return "paperElectronicEdition/paperElectronicEditionListByStudent";
		}
		PaperElectronicEdition paperElectronicEdition = null;
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		paperElectronicEdition = student.getPaperElectronicEdition();
		if(paperElectronicEdition==null){
			paperElectronicEdition = new PaperElectronicEdition();
		}else{
			CommonHelp.delete(httpSession, paperElectronicEdition.getUrl());
		}
		String folderName="paperElectronicEdition";
		String fileName="论文电子版";
		String url = CommonHelp.upload(paperElectronicEditionFile, httpSession, folderName, fileName);
		String updateDate = CommonHelp.getCurrentDate();
		paperElectronicEdition.setUpdateDate(updateDate);
		paperElectronicEdition.setSchool(student.getSchool());
		paperElectronicEdition.setUrl(url);
		paperElectronicEdition.setStudent(student);
		paperElectronicEdition.setTitle(paperElectronicEditionFile.getOriginalFilename());
		paperElectronicEditionService.update(paperElectronicEdition);
		PaperElectronicEdition pee = student.getPaperElectronicEdition();
		modelMap.put("paperElectronicEdition", pee);
		modelMap.put("info", "文件上传成功！");
		return "paperElectronicEdition/paperElectronicEditionListByStudent";
	}
	
	@RequestMapping("/downloadPaperElectronicEdition.html") 
	public void down(){
		
	}
}
