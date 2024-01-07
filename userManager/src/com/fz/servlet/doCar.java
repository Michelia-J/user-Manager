package com.fz.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fz.javabean.GoodsSingle;
import com.fz.toolbean.MyTools;
import com.fz.toolbean.ShopCar;

public class doCar extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		ShopCar myCar =(ShopCar) request.getSession().getAttribute("myCar");
		
		if (myCar==null)
		{
			 myCar =new ShopCar(); 
			 request.getSession().setAttribute("myCar", myCar);
		}
		
		String action = request.getParameter("action");
		if (action == null)
			action = "";
		if (action.equals("buy")) { // ������Ʒ
			ArrayList goodslist = (ArrayList) request.getSession().getAttribute("goodslist");
			int id = MyTools.strToint(request.getParameter("id"));
			GoodsSingle single = (GoodsSingle) goodslist.get(id);
			myCar.addItem(single); // ����ShopCar���е�addItem()���������Ʒ
			response.sendRedirect("show.jsp");
		} else if (action.equals("remove")) {
			String name = request.getParameter("name"); // ��ȡ��Ʒ����
			myCar.removeItem(name); // ����ShopCar���е�removeItem()�����Ƴ���Ʒ
			response.sendRedirect("show.jsp");
		} else if (action.equals("clear")) { // ��չ��ﳵ
			myCar.clearCar(); // ����ShopCar���е�clearCar()������չ��ﳵ
			response.sendRedirect("shopcar.jsp");
		} else {
			response.sendRedirect("show.jsp");
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}
}
