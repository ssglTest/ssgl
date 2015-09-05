package com.sdjz.loginInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptorHandler implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("拦截器开始工作。。。。。。。。。。。。。");
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		System.out.println(url);
		System.out.println(url.indexOf("login"));
		if(url.indexOf("login")>=0){
			System.out.println(url);
			return true;
		}
		String user = (String) session.getAttribute("user");
		System.out.println("username:   "+user);
		if(user!=null){
			return true;
		}
		
		///WEB-INF/jsp/login/login.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
		//return "redirect:/addFile.action";
		return false;
	}
}
