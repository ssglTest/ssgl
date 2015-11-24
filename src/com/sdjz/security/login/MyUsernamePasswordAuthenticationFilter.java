package com.sdjz.security.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.google.code.kaptcha.Constants;
import com.sdjz.domain.User;
import com.sdjz.help.CommonHelp;
import com.sdjz.service.UserService;

public class MyUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	@Autowired
	private UserService userService;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		if (!request.getMethod().equals("POST")) {
			throw new AuthenticationServiceException("authentication method not supported : " + request.getMethod());
		}

		System.out.println("test-----");
		
		// 获取session
		HttpSession httpSession = request.getSession();
		// 获取用户信息
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		//输入的验证码
		String verificationCode = request.getParameter("verifitcaionCode");
		//真实的验证码
		String realVerificationCode = (String) request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(verificationCode ==null || !verificationCode.equals(realVerificationCode)){
			throw new AuthenticationServiceException("验证码错误");
		}
		// 去除多余的空格
		username = username.trim();
		// 根据输入的username得到当前的user
		User storedUser = userService.findByUserName(username);
		if (storedUser == null)
			throw new AuthenticationServiceException("用户名不存在");
		if (CommonHelp.makeMD5(storedUser.getPassword()).equals(CommonHelp.makeMD5(password))) {
			httpSession.setAttribute("user", storedUser);
			System.out.println("======  密码相同   ======");
		} else {
			System.out.println("用户名或密码错误");
			throw new AuthenticationServiceException("用户名或密码错误");
		}
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
				password);
		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}

}
