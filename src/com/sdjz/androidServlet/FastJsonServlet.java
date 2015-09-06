package com.sdjz.androidServlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.alibaba.fastjson.JSON;
import com.sdjz.domain.User;
import com.sdjz.service.UserService;

@Controller
@WebServlet("/FastJsonServlet")
public class FastJsonServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	 public FastJsonServlet() {
	        // TODO Auto-generated constructor stub
	    }

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			doPost(request, response);
		}
		
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			UserService userService = new UserService();
			response.setContentType("text/html;charset=utf-8");
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			PrintWriter out = response.getWriter();
			
			User user = userService.findByUserName(username);
			
			if(user==null){
				out.println(JSON.toJSONString("userNoExist"));
			}else if(!password.equals(user.getPassword())){
				out.println(JSON.toJSONString("passwordError"));
			}else{
				out.println(JSON.toJSONString("userExist"));
			}
			System.out.println();
			out.flush();
			out.close();
		}

	}

