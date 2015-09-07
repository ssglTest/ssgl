package com.sdjz.webService.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;

import com.sdjz.domain.Tutor;
import com.sdjz.domain.User;
import com.sdjz.exception.MessageException;
import com.sdjz.service.TutorService;
import com.sdjz.service.UserService;
import com.sdjz.webService.service.SsglWebService;
@WebService(endpointInterface="com.sdjz.webService.service.SsglWebService",serviceName="webservice")
public class SsglWebServiceImpl implements SsglWebService {

	@Autowired
	private UserService userService;
	
	@Autowired
	private TutorService tutorService;
	@Override
	public Tutor login(String username, String password) {
		// TODO Auto-generated method stub
		User user = userService.findByUserName(username);
		System.out.println("tutor   =======:"+user);
		if(user==null){
			throw new MessageException("用户不存在");
		}
		String pd = user.getPassword();
		if(pd.equals(password)){
			//Tutor tutor = tutorService.findByNo(username);
			Tutor tutor=(Tutor)user.getActor();
			System.out.println("tutor***********"+tutor.getNo());
			return tutor;
		}else{
			throw new MessageException("用户名或密码错误");
		}
		
	}
	
	
	
	

}
