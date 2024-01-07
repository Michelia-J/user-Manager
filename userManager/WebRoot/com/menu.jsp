<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<a href="../index">购物</a>
<%if (session.getAttribute("userType").equals("1")) {%>
<a href="../userManage/userManager.jsp">用户管理</a>
<%} %>
<a href="../login/login.jsp">退出</a>
<br>