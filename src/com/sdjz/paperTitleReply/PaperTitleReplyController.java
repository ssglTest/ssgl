package com.sdjz.paperTitleReply;

import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.sdjz.domain.PaperTitleReply;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.PaperTitleReplyService;

@Controller
//paperTitleReplyTime/paperTitleReplyTimeList
@RequestMapping("userContro/paperTitleReply")
public class PaperTitleReplyController {
	
	@Autowired
	private PaperTitleReplyService paperTitleReplyService;
	
	@RequestMapping("/paperTitleReplyList.html")
	public String paperTitleReplyList(ModelMap modelMap){
		List<PaperTitleReply> paperTitleReplyList = paperTitleReplyService.findAll();
		modelMap.put("paperTitleReplyList", paperTitleReplyList);
		return "paperTitleReply/paperTitleReplyList";
	}
	@RequestMapping("/updatePaperTitleReply.html")
	public String updatePaperTitleReplyTime(HttpSession httpSession, ModelMap modelMap,
			@RequestParam(value = "paperTitleReplyFile") MultipartFile paperTitleReplyFile) {
		PaperTitleReply paperTitleReply = null;
		if(paperTitleReplyFile==null){
			String info="请选择文件！";
			modelMap.put("info", info);
			return "paperTitleReply/paperTitleReplyList";
		}
		List<PaperTitleReply> paperTitleReplyList = paperTitleReplyService.findAll();
		if(paperTitleReplyList.isEmpty()){
			paperTitleReply = new PaperTitleReply();
		}
		String folder = "paperTitleReplyDoc";
		String url = CommonHelp.upload(paperTitleReplyFile, httpSession, folder);
		String title = paperTitleReplyFile.getOriginalFilename();
		Calendar date = CommonHelp.getNow();
		paperTitleReply.setTitle(title);
		paperTitleReply.setUrl(url);
		paperTitleReply.setUpdateDate(date);
		paperTitleReplyService.update(paperTitleReply);
		paperTitleReplyService.save(paperTitleReply);
		return "redirect:/paperTitleReplyList.html";
	}
	
	@RequestMapping("/downloadPaperTitleReply.html")
	public String downloadPaperTitleReply(){
		return null;
	}

}
