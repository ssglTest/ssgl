package com.sdjz.loginInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Controller
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
		HttpSession session = request.getSession();
		String url = request.getRequestURI();
		if("login".indexOf(url)>=0){
			return true;
		}
		String username = (String) session.getAttribute("username");
		if(username!=null){
			
			return true;
		}
		
		request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
		return false;
	}

	
	
}
