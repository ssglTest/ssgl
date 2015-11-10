package com.sdjz.sciencePaperCheck;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.SciencePaperCheck;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.domain.Tutor;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.SciencePaperCheckService;
import com.sdjz.service.SecretaryService;
import com.sdjz.service.StudentService;
import com.sdjz.service.TutorService;

@Controller
@RequestMapping("userContro/sciencePaperCheck")
public class SciencePaperCheckController {

	@Autowired
	private SciencePaperCheckService sciencePaperCheckService;
	@Autowired
	private StudentService studentService;
	@Autowired
	private SecretaryService secretaryService;
	@Autowired
	private TutorService tutorService;

	/**
	 * 列出所有的学术论文检查表
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/sciencePaperCheckList.html")
	public String sciencePaperCheckList(ModelMap modelMap, HttpSession httpSession) {
		Tutor tutor = (Tutor) CommonHelp.getCurrentActor(httpSession);
		// 解决懒加载的问题
		tutor = tutorService.findByNo(tutor.getNo());
		List<SciencePaperCheck> sciencePaperCheckList = tutor.getSciencePaperCheck();
		modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		return "sciencePaperCheck/sciencePaperCheckList";
	}

	/**
	 * 研究生秘书存档学术论文考核记录表
	 * 
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/saveSciencePaperCheck.html")
	public String saveSciencePaperCheck(ModelMap modelMap, HttpSession httpSession) {
		// 得到当前的用户
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		// 获取研究生秘书所在学院的所有的学术论文考核记录表
		List<SciencePaperCheck> sciencePaperCheckList = secretary.getSchool().getSciencePaperChecks();
		// 添加到Map集合中
		modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		return "keepInTheArchives/sciencePaperCheckDoc";
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
		student = studentService.findByNo(student.getNo());
		SciencePaperCheck sciencePaperCheck = student.getSciencePaperCheck();
		modelMap.put("sciencePaperCheck", sciencePaperCheck);
		return "sciencePaperCheck/sciencePaperCheckListByStudent";
	}

	/**
	 * 上传学术论文检查表
	 * 
	 * @param sciencePaperCheckUploadFile
	 * @param httpSession
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/sciencePaperCheckUpload.html")
	public String sciencePaperCheckUpload(
			@RequestParam(value = "sciencePaperCheckUploadFile", required = false) MultipartFile sciencePaperCheckUploadFile,
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
		sciencePaperCheck.setSchool(student.getSchool());
		Tutor tutor = student.getTutor();
		sciencePaperCheck.setTutor(tutor);
		sciencePaperCheckService.update(sciencePaperCheck);
		SciencePaperCheck spc = student.getSciencePaperCheck();
		modelMap.put("sciencePaperCheck", spc);
		return "sciencePaperCheck/sciencePaperCheckListByStudent";
	}

	/**
	 * 文件下载
	 * 
	 * @param httpSession
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping("/sciencePaperCheckDownload.html")
	public ResponseEntity<byte[]> sciencePaperCheckDownload(HttpSession httpSession, Integer sciencePaperCheckId) {
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
	 * 
	 * @param modelMap
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping(value = "/excellentSciencePaperCheck.html", method = RequestMethod.POST)
	public void auditSciencePaperCheckExcellent(HttpSession httpSession, ModelMap modelMap, Integer sciencePaperCheckId,
			HttpServletResponse response) {
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String auditDate = CommonHelp.getCurrentDate();
		sciencePaperCheck.setAuditDate(auditDate);
		sciencePaperCheck.setApprove("excellent");
		sciencePaperCheckService.update(sciencePaperCheck);
		sciencePaperCheckService.save(sciencePaperCheck);
		CommonHelp.buildSimpleJson(response);
		/*
		 * List<SciencePaperCheck> sciencePaperCheckList =
		 * sciencePaperCheckService.findAll();
		 * modelMap.put("sciencePaperCheckList", sciencePaperCheckList); Tutor
		 * tutor = (Tutor) CommonHelp.getCurrentActor(httpSession); tutor =
		 * tutorService.findByNo(tutor.getNo()); //获取研究生秘书所在学院的所有的学术论文考核记录表
		 * List<SciencePaperCheck> sciencePaperCheckLis =
		 * tutor.getSchool().getSciencePaperChecks(); //添加到Map集合中
		 * modelMap.put("sciencePaperCheckList", sciencePaperCheckLis); return
		 * "sciencePaperCheck/sciencePaperCheckList";
		 */
	}

	/**
	 * 审核 良
	 * 
	 * @param modelMap
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping(value = "/goodSciencePaperCheck.html", method = RequestMethod.POST)
	public void auditSciencePaperCheckGood(HttpSession httpSession, ModelMap modelMap, Integer sciencePaperCheckId,
			HttpServletResponse response) {
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String auditDate = CommonHelp.getCurrentDate();
		sciencePaperCheck.setAuditDate(auditDate);
		sciencePaperCheck.setApprove("good");
		sciencePaperCheckService.update(sciencePaperCheck);
		sciencePaperCheckService.save(sciencePaperCheck);
		CommonHelp.buildSimpleJson(response);
		/*
		 * List<SciencePaperCheck> sciencePaperCheckList =
		 * sciencePaperCheckService.findAll();
		 * modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		 */
		/*
		 * Tutor tutor = (Tutor) CommonHelp.getCurrentActor(httpSession); tutor
		 * = tutorService.findByNo(tutor.getNo()); //获取研究生秘书所在学院的所有的学术论文考核记录表
		 * List<SciencePaperCheck> sciencePaperCheckLis =
		 * tutor.getSchool().getSciencePaperChecks(); //添加到Map集合中
		 * modelMap.put("sciencePaperCheckList", sciencePaperCheckLis); return
		 * "sciencePaperCheck/sciencePaperCheckList";
		 */
	}

	/**
	 * 审核 中
	 * 
	 * @param modelMap
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping(value = "/fairSciencePaperCheck.html", method = RequestMethod.POST)
	public void auditSciencePaperCheckFair(HttpSession httpSession, ModelMap modelMap, Integer sciencePaperCheckId,
			HttpServletResponse response) {
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String auditDate = CommonHelp.getCurrentDate();
		sciencePaperCheck.setAuditDate(auditDate);
		sciencePaperCheck.setApprove("fair");
		sciencePaperCheckService.update(sciencePaperCheck);
		sciencePaperCheckService.save(sciencePaperCheck);
		CommonHelp.buildSimpleJson(response);
		/*
		 * List<SciencePaperCheck> sciencePaperCheckList =
		 * sciencePaperCheckService.findAll();
		 * modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		 */
		/*
		 * Tutor tutor = (Tutor) CommonHelp.getCurrentActor(httpSession); tutor
		 * = tutorService.findByNo(tutor.getNo()); //获取研究生秘书所在学院的所有的学术论文考核记录表
		 * List<SciencePaperCheck> sciencePaperCheckLis =
		 * tutor.getSchool().getSciencePaperChecks(); //添加到Map集合中
		 * modelMap.put("sciencePaperCheckList", sciencePaperCheckLis); return
		 * "sciencePaperCheck/sciencePaperCheckList";
		 */
	}

	/**
	 * 审核 差
	 * 
	 * @param modelMap
	 * @param sciencePaperCheckId
	 * @return
	 */
	@RequestMapping(value = "/poorSciencePaperCheck.html", method = RequestMethod.POST)
	public void auditSciencePaperCheckPoor(HttpSession httpSession, ModelMap modelMap, Integer sciencePaperCheckId,
			HttpServletResponse response) {
		SciencePaperCheck sciencePaperCheck = sciencePaperCheckService.findById(sciencePaperCheckId);
		String auditDate = CommonHelp.getCurrentDate();
		sciencePaperCheck.setAuditDate(auditDate);
		sciencePaperCheck.setApprove("poor");
		sciencePaperCheckService.update(sciencePaperCheck);
		sciencePaperCheckService.save(sciencePaperCheck);
		CommonHelp.buildSimpleJson(response);
		/*
		 * List<SciencePaperCheck> sciencePaperCheckList =
		 * sciencePaperCheckService.findAll();
		 * modelMap.put("sciencePaperCheckList", sciencePaperCheckList);
		 */
		/*
		 * Tutor tutor = (Tutor) CommonHelp.getCurrentActor(httpSession); tutor
		 * = tutorService.findByNo(tutor.getNo()); //获取研究生秘书所在学院的所有的学术论文考核记录表
		 * List<SciencePaperCheck> sciencePaperCheckLis =
		 * tutor.getSchool().getSciencePaperChecks(); //添加到Map集合中
		 * modelMap.put("sciencePaperCheckList", sciencePaperCheckLis); return
		 * "sciencePaperCheck/sciencePaperCheckList";
		 */
	}

}
