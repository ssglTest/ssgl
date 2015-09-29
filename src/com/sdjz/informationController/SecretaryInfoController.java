package com.sdjz.informationController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.sdjz.domain.Secretary;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.SecretaryService;

@Controller
@RequestMapping("userContro")
public class SecretaryInfoController {
	@Autowired
	SecretaryService secretaryService;

	@RequestMapping(value = "/secretaryInfo.html")
	public String queryInfo(HttpSession httpSession, ModelMap modelMap) {
		Secretary secretary = (Secretary) CommonHelp.getCurrentActor(httpSession);
		// 通过当前用户的id，在数据库中重新获取数据，这样可以避免重新点击链接，数据又恢复到原来的数据
		modelMap.put("secretary", secretaryService.findById(secretary.getId()));
		return "userInformation/secretaryInfo";
	}

	@RequestMapping(value = "/updateSecretaryInfo.html", method = RequestMethod.POST)
	public String updateInfo(ModelMap modelMap, @RequestParam("email") String email,
			@RequestParam("mobile") String mobile, @RequestParam("qq") String qq,
			@RequestParam("secretaryId") Integer id) {
		Secretary secretary = secretaryService.findById(id);
		secretary.setEmail(email);
		secretary.setMobile(mobile);
		secretary.setQq(qq);
		secretaryService.update(secretary);
		secretaryService.save(secretary);
		modelMap.put("secretary", secretary);
		return "userInformation/secretaryInfo";
	}

}
