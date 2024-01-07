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

	//���ݳ�ʼ��
	public static  List<User> init_userList(){
		List<User> userlist = new ArrayList();
		
		try {
			//1������JDBC������
			Class.forName("com.mysql.jdbc.Driver");
			//2����������
			String url="jdbc:mysql://localhost:3307/210612";
			String user="root";
			String password="1234";	
			Connection conn=DriverManager.getConnection(url, user, password);
			//3��ִ��SQL���
			Statement stm=conn.createStatement();
			String SQL_="SELECT * FROM user";
			ResultSet res=stm.executeQuery(SQL_);
			//4�����ݵĲ�ѯ���
			int i=0;
			while (res.next()) {
				String login_name = res.getString("id");
				String name = res.getString("name");
				String sex= res.getString("�Ա�");
				String tel= res.getString("��ϵ��ʽ");
				String add= res.getString("��ַ");
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
			temp_user.setName("����Ա" ) ;
	        temp_user.setPw("210613");
			temp_user.setSex("��") ;
			temp_user.setTel( "123456789" );
			temp_user.setAdd("Ӧ�������ѧ") ;
			temp_user.setType("0");
			userlist.add(temp_user);
			//�ر����ݼ������ӵ�
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
	 * ��¼У�麯��
	 * @param username    �û���
	 * @param pw          ����
	 * @param userlist    �û��б�
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
