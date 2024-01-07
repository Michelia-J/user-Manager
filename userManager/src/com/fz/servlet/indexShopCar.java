package com.fz.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fz.javabean.GoodsSingle;

public class indexShopCar extends HttpServlet {
@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
	
	
	 ArrayList<GoodsSingle> goodslist=new ArrayList<GoodsSingle>();			//用来存储商品
		try {
			//1、加载驱动管理
			Class.forName("com.mysql.jdbc.Driver");
			//2、创建连接
			String url="jdbc:mysql://localhost:3307/210612";
			String user="root";
			String password="1234";						
			Connection conn=DriverManager.getConnection(url, user, password);
			//3、执行SQL语句
			Statement sat=conn.createStatement();
			String sql="SELECT * FROM goodssingle ";
			ResultSet res= sat.executeQuery(sql);
			while (res.next()) {
				String singleName=res.getString(1);
				float price=res.getFloat(2);				
				GoodsSingle single=new GoodsSingle();
				single.setName(singleName); 					//封装商品名称信息
				single.setPrice(price); 				//封装商品价格信息
				single.setNum(1); 							//封装购买数量信息
				goodslist.add(single); 					
				
				
			}
			res.close();
			sat.close();
			conn.close();
			
			
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			
			
			
		}
	    
	 
	 
	 
	 /*
	   //静态代码块
		String[] names={"苹果","香蕉","梨","橘子"};		//商品名称
		float[] prices={2.8f,3.1f,2.5f,2.3f};			//商品价格
		for(int i=0;i<4;i++){							//初始化商品信息列表
			//定义一个GoodsSingle类对象来封装商品信息			
			GoodsSingle single=new GoodsSingle();
			single.setName(names[i]); 					//封装商品名称信息
			single.setPrice(prices[i]); 				//封装商品价格信息
			single.setNum(1); 							//封装购买数量信息
			goodslist.add(i,single); 					//保存商品到goodslist集合对象中
		}	*/
	

	request.getSession().setAttribute("goodslist",goodslist); 		//保存商品列表到session中
	response.sendRedirect("shopCar/show.jsp");					//跳转到show.jsp页面显示商品


	
	
	
	
	
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
