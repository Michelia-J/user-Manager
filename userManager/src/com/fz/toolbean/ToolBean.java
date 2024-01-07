package com.fz.toolbean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.fz.javabean.User;

public class ToolBean {

	//数据初始化
	public static  List<User> init_userList(){
		List<User> userlist = new ArrayList();
		
		try {
			//1、加载JDBC的驱动
			Class.forName("com.mysql.jdbc.Driver");
			//2、创建连接
			String url="jdbc:mysql://localhost:3307/210612";
			String user="root";
			String password="1234";	
			Connection conn=DriverManager.getConnection(url, user, password);
			//3、执行SQL语句
			Statement stm=conn.createStatement();
			String SQL_="SELECT * FROM user";
			ResultSet res=stm.executeQuery(SQL_);
			//4、数据的查询结果
			int i=0;
			while (res.next()) {
				String login_name = res.getString("id");
				String name = res.getString("name");
				String sex= res.getString("性别");
				String tel= res.getString("联系方式");
				String add= res.getString("地址");
				String account=res.getString("account");
				User temp_user = new User();
				temp_user.setLogin_name(login_name);
				temp_user.setName(name) ;
		        temp_user.setPw("210612");
				temp_user.setSex(sex) ;
				temp_user.setTel( tel );
				temp_user.setAdd(add) ;
				temp_user.setType("1");
				temp_user.setAccount(account);
				userlist.add(i, temp_user);
				i++;
			}
			
			User temp_user = new User();
			temp_user.setLogin_name("admin001" ) ;
			temp_user.setName("管理员" ) ;
	        temp_user.setPw("210613");
			temp_user.setSex("男") ;
			temp_user.setTel( "123456789" );
			temp_user.setAdd("应急管理大学") ;
			temp_user.setType("0");
			userlist.add(temp_user);
			//关闭数据集、连接等
			res.close();
			stm.close();
			conn.close();
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return userlist;
	}
	/**
	 * 登录校验函数
	 * @param username    用户名
	 * @param pw          密码
	 * @param userlist    用户列表
	 * @return
	 */
	public static boolean   check_Login(String username,String pw,List<User> userlist){
		boolean check_login=false;
		for(int i=0;i<userlist.size();i++)
		{
		   User temp_user=userlist.get(i);
		  if(username.equals(temp_user.getLogin_name()) && pw.equals(temp_user.getPw()))
		  {  check_login=true;
		      
		  break;
		  }
		}
		return check_login;
		
	}
	
 	public static String getUserType(String username,String pw,List<User> userlist){
		
		
		String  userType="";
		for(int i=0;i<userlist.size();i++)
		{
		   User temp_user=userlist.get(i);
		  if(username.equals(temp_user.getLogin_name()) && pw.equals(temp_user.getPw()))
		  {  
			  userType=temp_user.getType();
		  break;
		  }
		}
		return userType;
		
	}	
}
