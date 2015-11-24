package com.sdjz.loginInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptorHandler implements HandlerInterceptor{

	private static final Logger logger = Logger.getLogger(LoginInterceptorHandler.class);
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

	/**
	 * 在执行所有的controller方法之前进行拦截，判断用户是否存在
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
		// TODO Auto-generated method stub
		//HttpSession session = request.getSession();
		String url = request.getRequestURI();
		if(logger.isDebugEnabled()){
			logger.debug("请求的URL:" + url);
		}
		return true;
		/*System.out.println(url);
		System.out.println(url.indexOf("login"));*/
		/*if(url.indexOf("login")>=0){
			System.out.println(url);
			return true;
		}
		User user = (User) session.getAttribute("user");
		System.out.println("username:   "+user);
		if(user!=null){
			return true;
		}
		
		///WEB-INF/jsp/login/login.jsp
		request.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(request, response);
		//return "redirect:/addFile.action";
		return false;*/
	}
}
