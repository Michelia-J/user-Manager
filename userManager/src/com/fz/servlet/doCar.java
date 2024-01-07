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
		if (action.equals("buy")) { // 购买商品
			ArrayList goodslist = (ArrayList) request.getSession().getAttribute("goodslist");
			int id = MyTools.strToint(request.getParameter("id"));
			GoodsSingle single = (GoodsSingle) goodslist.get(id);
			myCar.addItem(single); // 调用ShopCar类中的addItem()方法添加商品
			response.sendRedirect("show.jsp");
		} else if (action.equals("remove")) {
			String name = request.getParameter("name"); // 获取商品名称
			myCar.removeItem(name); // 调用ShopCar类中的removeItem()方法移除商品
			response.sendRedirect("show.jsp");
		} else if (action.equals("clear")) { // 清空购物车
			myCar.clearCar(); // 调用ShopCar类中的clearCar()方法清空购物车
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
