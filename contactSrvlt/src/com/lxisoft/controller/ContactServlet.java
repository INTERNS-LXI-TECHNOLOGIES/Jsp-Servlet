package com.lxisoft.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;

public class ContactServlet extends HttpServlet{
	

	@Override
public void doPost(HttpServletRequest request,HttpServletResponse response){
	Connection connection = null;
		Statement stmt = null;
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>put working");
	String name=(String)request.getSession().getAttribute("a");
	//int id=generateId();
	String phone=(String)request.getSession().getAttribute("b");
	String place=(String)request.getSession().getAttribute("c");
	String emailId=(String)request.getSession().getAttribute("d");
	System.out.println(">>>>>>>>>>>>>>"+emailId);
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact","root","root");
			stmt=connection.createStatement();
			String sql= "INSERT INTO contable(name,phoneNumber,place,emailID) "+"VALUES ('"+name+"','"+phone+"','"+place+"','"+emailId+"')";
			//ResultSet rs = null;	
			  //stmt.execute(sql);
			System.out.println("/////////////"+stmt.execute(sql));
			
			connection.close();
			response.sendRedirect("Contact.jsp?result=success");
		}
		catch(Exception e){
			
			System.out.println(e);
			try{
			response.sendRedirect("Contact.jsp?result=faild");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
		

	
	}
	
		
		
	
		
}