package com.sdjz.paperElectronicEdition;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.PaperElectronicEdition;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperElectronicEditionService;
import com.sdjz.service.SecretaryService;

@Controller
@RequestMapping("paperElectronicEdition")
public class PaperElectronicEditionController {

	@Autowired
	private PaperElectronicEditionService paperElectronicEditionService;
	@Autowired
	private SecretaryService secretaryService;

	@RequestMapping("/paperElectronicEditionListByStudent.html")
	public String paperElectronicEditionListByStudent(ModelMap modelMap, HttpSession httpSession) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		PaperElectronicEdition paperElectronicEdition = student.getPaperElectronicEdition();
		modelMap.put("paperElectronicEdition", paperElectronicEdition);
		return "paperElectronicEdition/paperElectronicEditionListByStudent";
	}
	
	public String paperElectronicEdtionListBySecretary(HttpSession httpSession,ModelMap modelMap){
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		List<PaperElectronicEdition> paperElectronicEditionList = secretary.getSchool().getPaperElectronicEditions();
		modelMap.put("paperElectronicEditionList", paperElectronicEditionList);
		return "paperElectronicEdition/paperElectronicEditionListBySecretary";
	}

	@RequestMapping("/updatePaperElectronicEdition.html")
	public String update(ModelMap modelMap, HttpSession httpSession,
			@RequestParam(value = "paperElectronicEditionFile", required = false) MultipartFile paperElectronicEditionFile) {
		if (paperElectronicEditionFile == null) {
			modelMap.put("info", "请选择文件！");
			return "paperElectronicEdition/paperElectronicEditionListByStudent";
		}
		PaperElectronicEdition paperElectronicEdition = null;
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		paperElectronicEdition = student.getPaperElectronicEdition();
		if (paperElectronicEdition == null) {
			paperElectronicEdition = new PaperElectronicEdition();
		} else {
			CommonHelp.delete(httpSession, paperElectronicEdition.getUrl());
		}
		String folderName = "paperElectronicEdition";
		String fileName = "论文电子版";
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
	public ResponseEntity<byte[]> download(HttpSession httpSession, Integer paperElectronicEditionId)
			throws IOException {
		PaperElectronicEdition paperElectronicEdition = paperElectronicEditionService
				.findById(paperElectronicEditionId);
		String name = "论文电子版";
		return CommonHelp.download(httpSession, paperElectronicEdition.getUrl(), name);
	}
}
