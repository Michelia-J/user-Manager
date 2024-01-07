<%@page import="javax.tools.Tool"%>
<%@ page language="java" import="java.util.*,com.fz.javabean.*,com.fz.toolbean.*" pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%

	List <User> userlist=ToolBean.init_userList();
	
	
%>





<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>



<title>用户管理</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<script type="text/javascript">
function del_info($this){
      
    alert($this);
   

}


</script>
</head>

<body>
<%@ include file="../com/menu.jsp" %>


	用户管理 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp 登录人：<%=session.getAttribute("userName") %>
	<table border="1" width="100%">
		<tr>
		<td>序号</td>
		<td>登录名</td>
			<td>姓名</td>
			<td>性别</td>
			<td>联系方式</td>
			<td>地址</td>
			<td>账单</td>>
			<td>操作</td>
		</tr>
		<%
			for (int i = 0; i < userlist.size(); i++) {
				User temp_user_02 = userlist.get(i);
		%>
		<tr>
		<td><%=i+1%></td>
		<td><%=temp_user_02.getLogin_name()%></td>
			<td><%=temp_user_02.getName()%></td>
			<td><%=temp_user_02.getSex()%></td>
			<td><%=temp_user_02.getTel()%></td>
			<td><%=temp_user_02.getAdd()%></td>
			<td><%=temp_user_02.getAccount()%></td>>
           <td><a href="delUser?login_name=<%=temp_user_02.getLogin_name() %>">删除用户</td>
		</tr>
		
		<%
			}
		%>
	</table>
















</body>
</html>
