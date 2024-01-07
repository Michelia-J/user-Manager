package com.fz.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fz.javabean.GoodsSingle;

public class delUser extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String login_name=request.getParameter("login_name");
		System.out.println(login_name);
		
		
		try {
			//1、加载驱动管理
			Class.forName("com.mysql.jdbc.Driver");
			//2、创建连接
			String url="jdbc:mysql://localhost:3307/210612";
			String user="root";
			String password="root";				
			Connection conn=DriverManager.getConnection(url, user, password);
			//3、执行SQL语句
			Statement sat=conn.createStatement();
			String sql="DELETE FROM `user` WHERE `user`.`id`='"+login_name+"'";
			int res= sat.executeUpdate(sql);
			
			System.out.println(res);
			sat.close();
			conn.close();
			
			
			
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			response.sendRedirect("../userManage/userManager.jsp");
			
			
		}
		
		
		
		
		
		
		
		
		
		
	
	}

}
