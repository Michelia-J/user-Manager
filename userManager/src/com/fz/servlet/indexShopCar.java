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
	
	
	 ArrayList<GoodsSingle> goodslist=new ArrayList<GoodsSingle>();			//�����洢��Ʒ
		try {
			//1��������������
			Class.forName("com.mysql.jdbc.Driver");
			//2����������
			String url="jdbc:mysql://localhost:3307/210612";
			String user="root";
			String password="1234";						
			Connection conn=DriverManager.getConnection(url, user, password);
			//3��ִ��SQL���
			Statement sat=conn.createStatement();
			String sql="SELECT * FROM goodssingle ";
			ResultSet res= sat.executeQuery(sql);
			while (res.next()) {
				String singleName=res.getString(1);
				float price=res.getFloat(2);				
				GoodsSingle single=new GoodsSingle();
				single.setName(singleName); 					//��װ��Ʒ������Ϣ
				single.setPrice(price); 				//��װ��Ʒ�۸���Ϣ
				single.setNum(1); 							//��װ����������Ϣ
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
	   //��̬�����
		String[] names={"ƻ��","�㽶","��","����"};		//��Ʒ����
		float[] prices={2.8f,3.1f,2.5f,2.3f};			//��Ʒ�۸�
		for(int i=0;i<4;i++){							//��ʼ����Ʒ��Ϣ�б�
			//����һ��GoodsSingle���������װ��Ʒ��Ϣ			
			GoodsSingle single=new GoodsSingle();
			single.setName(names[i]); 					//��װ��Ʒ������Ϣ
			single.setPrice(prices[i]); 				//��װ��Ʒ�۸���Ϣ
			single.setNum(1); 							//��װ����������Ϣ
			goodslist.add(i,single); 					//������Ʒ��goodslist���϶�����
		}	*/
	

	request.getSession().setAttribute("goodslist",goodslist); 		//������Ʒ�б�session��
	response.sendRedirect("shopCar/show.jsp");					//��ת��show.jspҳ����ʾ��Ʒ


	
	
	
	
	
}
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
