package com.sdjz.sciencePaperCheck;

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

import com.sdjz.domain.SciencePaperCheck;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.SciencePaperCheckService;

@Controller
@RequestMapping("userContro/sciencePaperCheck")
public class SciencePaperCheckController {

	@Autowired
	private SciencePaperCheckService sciencePaperCheckService;

	/**
	 * 列出所有的学术论文检查表
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/sciencePaperCheckList.html")
	public String sciencePaperCheckList(ModelMap modelMap) {
		List<SciencePaperCheck> sciencePaperCheckList = sciencePaperCheckService.findAll();
		modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		return "sciencePaperCheck/sciencePaperCheckList";
	}

	/**
	 * 根据学生得到学术论文检查表
	 * 
	 * @param modelMap
	 * @param httpSession
	 * @return
	 */
	@RequestMapping("/sciencePaperCheckListByStudent.html")
	public String sciencePaperCheckListByStudent(ModelMap modelMap, HttpSession httpSession) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		SciencePaperCheck sciencePaperCheck = student.getSciencePaperCheck();
		modelMap.put("sciencePaperCheck", sciencePaperCheck);
		return "sciencePaperCheck/sciencePaperCheckListByStudent";
	}

	/**
	 * 上传学术论文检查表
	 * @param sciencePaperCheckUploadFile
	 * @param httpSession
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/sciencePaperCheckUpload.html")
	public String sciencePaperCheckUpload(
			@RequestParam(value = "sciencePaperCheckUpload", required = false) MultipartFile sciencePaperCheckUploadFile,
			HttpSession httpSession, ModelMap modelMap) {
		SciencePaperCheck sciencePaperCheck = null;
		if (sciencePaperCheckUploadFile == null) {
			modelMap.put("info", "请选择文件");
			return "warning/error";
		}
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		sciencePaperCheck = student.getSciencePaperCheck();
		if (sciencePaperCheck == null) {
			sciencePaperCheck = new SciencePaperCheck();
			sciencePaperCheck.setStudent(student);
			student.setSciencePaperCheck(sciencePaperCheck);
		} else {
			CommonHelp.delete(httpSession, sciencePaperCheck.getUrl());
		}
		String folderName = "sciencePaperCheck";
		String fileName = "学术论文检查表";
		String url = CommonHelp.upload(sciencePaperCheckUploadFile, httpSession, folderName, fileName);
		String date = CommonHelp.getCurrentDate();
		String title = sciencePaperCheckUploadFile.getOriginalFilename();
		sciencePaperCheck.setTitle(title);
		sciencePaperCheck.setUpdataDate(date);
		sciencePaperCheck.setUrl(url);
		sciencePaperCheckService.update(sciencePaperCheck);
		SciencePaperCheck spc = student.getSciencePaperCheck();
		modelMap.put("sciencePaperCheck", spc);
		return "sciencePaperCheck/sciencePaperCheckListByStudent";
	}
	
	/**
	 * 文件下载
	 * @param httpSession
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping("/sciencePaperCheckDownload.html")
	public ResponseEntity<byte[]> sciencePaperCheckDownload(HttpSession httpSession,Integer sciencePaperCheckId){
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String name = "学术论文检查表";
		try {
			return CommonHelp.download(httpSession, sciencePaperCheck.getUrl(), name);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 审核 优
	 * @param modelMap
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping("/excellentSciencePaperCheck.html")
	public String auditSciencePaperCheckExcellent(ModelMap modelMap,Integer sciencePaperCheckId){
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String auditDate = CommonHelp.getCurrentDate();
		sciencePaperCheck.setAuditDate(auditDate);
		sciencePaperCheck.setApprove("excellent");
		sciencePaperCheckService.update(sciencePaperCheck);
		sciencePaperCheckService.save(sciencePaperCheck);
		List<SciencePaperCheck> sciencePaperCheckList = sciencePaperCheckService.findAll();
		modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		return "sciencePaperCheck/sciencePaperCheckList";
	}
	
	/**
	 * 审核 良
	 * @param modelMap
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping("/goodSciencePaperCheck.html")
	public String auditSciencePaperCheckGood(ModelMap modelMap,Integer sciencePaperCheckId){
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String auditDate = CommonHelp.getCurrentDate();
		sciencePaperCheck.setAuditDate(auditDate);
		sciencePaperCheck.setApprove("good");
		sciencePaperCheckService.update(sciencePaperCheck);
		sciencePaperCheckService.save(sciencePaperCheck);
		List<SciencePaperCheck> sciencePaperCheckList = sciencePaperCheckService.findAll();
		modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		return "sciencePaperCheck/sciencePaperCheckList";
	}
	
	/**
	 * 审核 中
	 * @param modelMap
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping("/fairSciencePaperCheck.html")
	public String auditSciencePaperCheckFair(ModelMap modelMap,Integer sciencePaperCheckId){
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String auditDate = CommonHelp.getCurrentDate();
		sciencePaperCheck.setAuditDate(auditDate);
		sciencePaperCheck.setApprove("fair");
		sciencePaperCheckService.update(sciencePaperCheck);
		sciencePaperCheckService.save(sciencePaperCheck);
		List<SciencePaperCheck> sciencePaperCheckList = sciencePaperCheckService.findAll();
		modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		return "sciencePaperCheck/sciencePaperCheckList";
	}
	
	/**
	 * 审核 差
	 * @param modelMap
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping("/poorSciencePaperCheck.html")
	public String auditSciencePaperCheckPoor(ModelMap modelMap,Integer sciencePaperCheckId){
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String auditDate = CommonHelp.getCurrentDate();
		sciencePaperCheck.setAuditDate(auditDate);
		sciencePaperCheck.setApprove("poor");
		sciencePaperCheckService.update(sciencePaperCheck);
		sciencePaperCheckService.save(sciencePaperCheck);
		List<SciencePaperCheck> sciencePaperCheckList = sciencePaperCheckService.findAll();
		modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		return "sciencePaperCheck/sciencePaperCheckList";
	}

}
