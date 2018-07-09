package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class AddController extends HttpServlet{
	
	
	
	@Override
	public void doGet(HttpServletRequest request,HttpServletResponse response){
	System.out.println("addController/post working++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	String name=request.getParameter("name");
	int id=generateId();
	String phone=request.getParameter("phone");
		try{
		Class.forName("com.mysql.jdbc.Driver");
			  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
			Statement statement=connection.createStatement();
			statement.execute("insert into contacts values("+id+",'"+name+"',"+phone+")");
			connection.close();
			response.sendRedirect("AddContacts2.jsp?result=done&name="+name+"&phone="+phone);
			
		}
		catch(Exception e){
			
			System.out.println(e);
			try{
			response.sendRedirect("AddContacts2.jsp?result=faild&name="+name+"&phone="+phone);
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
	
	
	}
		public int generateId(){
		
		return (int)((Math.random()*7)+(Math.random()*9)-(Math.random()*3)%(Math.random()*5)+((Math.random()*9)*(Math.random()*9)));
		
		}
	
	
	
} 