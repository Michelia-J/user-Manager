package com.fz.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fz.javabean.User;
import com.fz.toolbean.ToolBean;
import com.sun.net.httpserver.HttpServer;

public class loginDo extends HttpServlet{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException {
	// TODO Auto-generated method stub
	//super.doGet(req, resp);
	
	this.doPost(req, resp);
}

@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.doPost(req, resp);
	request.setCharacterEncoding("utf-8");//post
	HttpSession session=request.getSession();
	String username=request.getParameter("userName");
	String pw =request.getParameter("pw");
	List <User> userlist=ToolBean.init_userList();
	boolean check_login=ToolBean.check_Login(username, pw, userlist);
	  if(check_login)
	   {  
	   session.setAttribute("userType", ToolBean.getUserType(username, pw, userlist)); 
	   session.setAttribute("userName", username); 
	   response.sendRedirect("../index");
	   
	   //request.getRequestDispatcher("../userManager.jsp").forward(request, response);
	   }
	else{response.sendRedirect("error.jsp");
		} 
	
	
	
	}
}
