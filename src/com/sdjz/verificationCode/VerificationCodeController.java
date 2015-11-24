package com.sdjz.verificationCode;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;


@Controller
@RequestMapping("kaptcha")
public class VerificationCodeController {

	@Autowired
	private Producer captchaProducer;
	
	@RequestMapping("/getKaptchaImage.html")
	public ResponseEntity<byte[]> getKaptchaImage(HttpSession httpSession) throws Exception{
		//使用spring，创建验证码code
		String capText = captchaProducer.createText();
		//存在session中
		httpSession.setAttribute(Constants.KAPTCHA_SESSION_KEY, capText);
		//为这个验证码创建图片
		BufferedImage bufferedImage = captchaProducer.createImage(capText);
		//创建一个空的file
		File file = new File("checkImg");
		//格式化为jpg
		ImageIO.write(bufferedImage, "jpg", file);
		//文件下载
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		//设置默认的名字
		headers.setContentDispositionFormData("attachment", "checkImg");
		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers,HttpStatus.CREATED);
	}
}
