package com.sdjz.midtermCheck;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.MidtermCheck;
import com.sdjz.domain.PaperTitleReport;
import com.sdjz.domain.Secretary;
import com.sdjz.domain.Student;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.MidtermCheckService;
import com.sdjz.service.SecretaryService;

/**
 * 中期检查表的controller
 * 
 * @author zhan
 *
 */
@Controller
@RequestMapping("userContro/midtermCheck")
public class MidtermCheckController {

	@Autowired
	private MidtermCheckService midtermCheckService;
	@Autowired
	private SecretaryService secretaryService;
	/**
	 * 获得当前学生的中期检查表
	 * 
	 * @param modelMap
	 * @param httpSession
	 * @return
	 */
	@RequestMapping("/midtermCheckListByStudent.html")
	public String midtermCheckListByStudent(ModelMap modelMap, HttpSession httpSession) {
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		PaperTitleReport paperTitleReport = student.getPaperTitleReport();
		if(paperTitleReport==null)
			return "warning/error";
		String approve = paperTitleReport.getApprove();
		if(approve.equals("notApproved"))
			return "warning/error";
		MidtermCheck midtermCheck = student.getMidtermCheck();
		modelMap.put("midtermCheck", midtermCheck);
		return "midtermCheck/midtermCheckListByStudent";
	}

	/**
	 * 研究生秘书获取中期检查表
	 * @param modelMap
	 * @return
	 */
	@RequestMapping("/midtermCheckList.html")
	public String midtermCheckList(ModelMap modelMap,HttpSession httpSession){
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		secretary = secretaryService.findByNo(secretary.getNo());
		List<MidtermCheck> midtermCheckList = secretary.getSchool().getMidtermChecks();
		modelMap.put("midtermCheckList", midtermCheckList);
		return "midtermCheck/midtermCheckList";
	}
	/**
	 * 上传中期检查表
	 * 
	 * @param midtermCheckUpdate
	 * @param httpSession
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value = "/midtermCheckUpload.html", method = RequestMethod.POST)
	public String midtermCheckUpload(
			@RequestParam(value = "midtermCheckUpdate", required = false) MultipartFile midtermCheckUpdate,
			HttpSession httpSession, ModelMap modelMap) {
		MidtermCheck midtermCheck = null;
		if (midtermCheckUpdate == null) {
			modelMap.put("info", "请选择文件");
			return "midtermCheck/midtermCheckListByStudent";
		}
		Student student = (Student) CommonHelp.getCurrentActor(httpSession);
		midtermCheck = student.getMidtermCheck();
		if (midtermCheck == null) {
			midtermCheck = new MidtermCheck();
			// 设置关联关系
			midtermCheck.setStudent(student);
			student.setMidtermCheck(midtermCheck);
		} else {
			CommonHelp.delete(httpSession, midtermCheck.getUrl());
		}
		String folderName = "midtermCheck";
		String fileName = "中期检查表";
		String url = CommonHelp.upload(midtermCheckUpdate, httpSession, folderName, fileName);
		String date = CommonHelp.getCurrentDate();
		String title = midtermCheckUpdate.getOriginalFilename();
		midtermCheck.setUpdateDate(date);
		midtermCheck.setTitle(title);
		midtermCheck.setUrl(url);
		midtermCheckService.update(midtermCheck);
		// 重新获取
		MidtermCheck mid = student.getMidtermCheck();
		modelMap.put("info", "文件上传成功");
		modelMap.put("midtermCheck", mid);
		return "midtermCheck/midtermCheckListByStudent";
	}

	/**
	 * 下载中期检查表
	 * 
	 * @param httpSession
	 * @param midtermCheckId
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/midtermCheckDownload.html")
	public ResponseEntity<byte[]> downMidtermCheck(HttpSession httpSession, Integer midtermCheckId) throws IOException {
		MidtermCheck midtermCheck = midtermCheckService.findById(midtermCheckId);
		String name = "中期检查表";
		return CommonHelp.download(httpSession, midtermCheck.getUrl(), name);
	}
	
	/**
	 * 审核通过
	 * @param modelMap
	 * @param midtermCheckId
	 * @return
	 */
	@RequestMapping("/midtermCheckApproved.html")
	public String midtermCheckApproved(ModelMap modelMap,Integer midtermCheckId){
		MidtermCheck midtermCheck = midtermCheckService.findById(midtermCheckId);
		midtermCheck.setApprove("approved");
		String date = CommonHelp.getCurrentDate();
		midtermCheck.setAuditDate(date);
		midtermCheckService.update(midtermCheck);
		midtermCheckService.save(midtermCheck);
		List<MidtermCheck> midtermCheckList = midtermCheckService.findAll();
		modelMap.put("midtermCheckList", midtermCheckList);
		return "midtermCheck/midtermCheckList";
	}
	
	/**
	 * 审核不通过
	 * @param modelMap
	 * @param midtermCheckId
	 * @return
	 */
	@RequestMapping("/midtermCheckNotApproved.html")
	public String midtermCheckNotApproved(ModelMap modelMap,Integer midtermCheckId){
		MidtermCheck midtermCheck = midtermCheckService.findById(midtermCheckId);
		midtermCheck.setApprove("notApproved");
		String date = CommonHelp.getCurrentDate();
		midtermCheck.setAuditDate(date);
		midtermCheckService.update(midtermCheck);
		midtermCheckService.save(midtermCheck);
		List<MidtermCheck> midtermCheckList = midtermCheckService.findAll();
		modelMap.put("midtermCheckList", midtermCheckList);
		return "midtermCheck/midtermCheckList";
	}

}
