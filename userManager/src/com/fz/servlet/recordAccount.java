package com.fz.servlet;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.sql.*;

public class recordAccount extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String count = request.getParameter("total");
		String username=(String)session.getAttribute("userName");
		
		//Á¬½Ó
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3307/210612";
		String user="root";
		String password="root";		
		Connection connection=DriverManager.getConnection(url,user,password);
		
		Statement state=connection.createStatement();
		
		
		String sql="update `user` set account= '"+count+"' WHERE `id`='"+username+"'";
		System.out.println(sql);
		int res= state.executeUpdate(sql);
		System.out.println(res);
		
		
		state.close();
		connection.close();
		
		
		}
		catch(Exception e){
			e.printStackTrace();
		}
		finally{
			response.sendRedirect("../shopCar/show.jsp");
			
		}
	}
}
