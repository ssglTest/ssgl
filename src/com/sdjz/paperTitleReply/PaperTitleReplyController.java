package com.sdjz.paperTitleReply;

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

import com.sdjz.domain.PaperTitleReply;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperTitleReplyService;

@Controller
// paperTitleReplyTime/paperTitleReplyTimeList
@RequestMapping("userContro/paperTitleReply")
public class PaperTitleReplyController {

	@Autowired
	private PaperTitleReplyService paperTitleReplyService;

	@RequestMapping("/paperTitleReplyList.html")
	public String paperTitleReplyList(ModelMap modelMap) {
		List<PaperTitleReply> paperTitleReplyList = paperTitleReplyService.findAll();
		modelMap.put("paperTitleReplyList", paperTitleReplyList);
		return "paperTitleReply/paperTitleReplyList";
	}
	
	@RequestMapping("/paperTitleReplyListByStudent.html")
	public String paperTitleReplyListByStudent(ModelMap modelMap){
		List<PaperTitleReply> paperTitleReplyListByStudent = paperTitleReplyService.findAll();
		modelMap.put("paperTitleReplyList", paperTitleReplyListByStudent);
		return "paperTitleReply/paperTitleReplyListByStudent";
	}

	@RequestMapping(value = "/paperTitleApplyUpload.html", method = RequestMethod.POST)
	public String updatePaperTitleReplyTime(HttpSession httpSession, ModelMap modelMap,
			@RequestParam(value = "paperTitleReplyFile") MultipartFile paperTitleReplyFile) {
		if (paperTitleReplyFile == null) {
			String info = "请选择文件！";
			modelMap.put("info", info);
			return "paperTitleReply/paperTitleReplyList";
		}
		//List<PaperTitleReply> paperTitleReplyList = paperTitleReplyService.findAll();
		//if (paperTitleReplyList.isEmpty()) {
		PaperTitleReply paperTitleReply = new PaperTitleReply();
		//}
		String folder = "paperTitleReplyDoc";
		String url = CommonHelp.upload(paperTitleReplyFile, httpSession, folder);
		String title = paperTitleReplyFile.getOriginalFilename();
		//Calendar date = CommonHelp.getNow();
		Integer day = CommonHelp.getDay();
		Integer month = CommonHelp.getMonth()+1;
		Integer year = CommonHelp.getYear();
		String date = day+"/"+month+"/"+year;
		paperTitleReply.setTitle(title);
		paperTitleReply.setUrl(url);
		paperTitleReply.setDate(date);
		paperTitleReplyService.save(paperTitleReply);
		//重新获取
		List<PaperTitleReply> listPaperTitleReply = paperTitleReplyService.findAll();
		String info="上传成功！";
		modelMap.put("paperTitleReplyList", listPaperTitleReply);
		modelMap.put("info", info);
		return "paperTitleReply/paperTitleReplyList";
	}

	@RequestMapping("/downloadPaperTitleReply.html")
	public ResponseEntity<byte[]> downloadPaperTitleReply(HttpSession httpSession,Integer paperTitleReplyId) throws IOException {
		PaperTitleReply paperTitleReply = paperTitleReplyService.findById(paperTitleReplyId);
		String name = "学位论文选题报告";
		return CommonHelp.download(httpSession, paperTitleReply.getUrl(), name);
	}

}
