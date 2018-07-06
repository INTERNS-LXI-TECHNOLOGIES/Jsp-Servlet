package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class EditContact extends HttpServlet{
	
	
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response){
	System.out.println("post working++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	Stirnd id=request.getParameter("id");
		try{
		Class.forName("com.mysql.jdbc.Driver");
			  Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
			Statement statement=connection.createStatement();
			statement.execute("update contacts set name='"+name+"',phone='"+phone+"' where id="+id);
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