package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import  java.util.logging.*;
import javax.naming.*;
public class EditController extends HttpServlet{
	
	static Logger logger=Logger.getLogger("EditController.class");
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response){
	System.out.println("Edit//post working ++++++++++++++++++++++++++++");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	int id=Integer.valueOf(request.getParameter("id"));
	System.out.println("2edit//name="+((String)request.getParameter("name"))+" phone="+((String)request.getParameter("phone"))+" id="+id);
	try{
	FileHandler fileHandler=new FileHandler("D://apache-tomcat-7.0.72/webapps/Contactsv1.4/WEB-INF/log.txt");
	logger.addHandler(fileHandler);
	SimpleFormatter formatter=new SimpleFormatter();
	fileHandler.setFormatter(formatter);
	}
	catch(IOException v)
	{
		v.printStackTrace();
	}
	logger.info("log working");
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
}