package com.sdjz.other;

import javax.servlet.http.HttpSession;

import com.sdjz.domain.Actor;
import com.sdjz.domain.User;
import com.sdjz.exception.UserInvalidException;


public class Common {
	
	//每页的记录数
	public final static Integer NUM_PER_PAGE = 20;
	
	//项目文件所在文件夹
	public final static String UPLOAD_DIR = "\\projectFile\\";
	
	public final static String ASC = "asc";
	public final static String DESC = "desc";
	
	//获取系统当前用户对应的actor
	public static Actor getCurrentActor(HttpSession httpSession){
		User user=getCurrentUser(httpSession);
		return user.getActor();
	}
	/**
	 * 通过HttpSession获取当前登录用户
	 * 如果httpsession中不存在对应的user，需要重新登录
	 * @param httpSession
	 * @return
	 */
	//获取当前系统对应的user
	public static User getCurrentUser(HttpSession httpSession){
		User user=(User) httpSession.getAttribute("user");
		if(user==null){
			throw new UserInvalidException("请重新登陆");
		}
		return user;
	}

}
