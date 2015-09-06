package com.sdjz.webService.service;

import javax.jws.WebParam;
import javax.jws.WebService;

import com.sdjz.domain.Tutor;

@WebService
public interface SsglWebService {

	public Tutor login(@WebParam(name= "username")String username,@WebParam(name="password")String password);
	
}
