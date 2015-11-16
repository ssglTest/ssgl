package com.sdjz.security.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

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

		// 获取session
		HttpSession httpSession = request.getSession();
		// 获取用户信息
		String username = (String) request.getAttribute("username");
		String password = (String) request.getAttribute("password");

		// 去除多余的空格
		username = username.trim();
		// 根据输入的username得到当前的user
		User storedUser = userService.findByUserName(username);
		if (storedUser == null)
			throw new AuthenticationServiceException("用户名不存在");
		if (storedUser.getPassword().equals(CommonHelp.makeMD5(password))) {
			httpSession.setAttribute("user", storedUser);
		} else {
			throw new AuthenticationServiceException("用户名或密码错误");
		}
		UsernamePasswordAuthenticationToken authRequest = new UsernamePasswordAuthenticationToken(username,
				CommonHelp.makeMD5(password));
		setDetails(request, authRequest);
		return this.getAuthenticationManager().authenticate(authRequest);
	}

}
