package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SearchController extends HttpServlet{
	
	public void doGet(HttpServletRequest request,HttpServletResponse response){
	System.out.println("get/search is working");
	String getName=request.getParameter("name");
	Connection conn = null;
	Statement stmt = null;
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");

		stmt = conn.createStatement();
		String sql2="select name from contable";
		
		
		String sql = "select * from contable where name='"+getName+"'";
		
		ResultSet rs = null;
			Contact contact=new Contact("none","none","none","none");
		rs = stmt.executeQuery(sql);
	
	
	
	while (rs.next()) {
			contact =new Contact(rs.getString("name"),rs.getString("phoneNumber"),rs.getString("place"),rs.getString("emailID"));
			
						
			request.getSession().setAttribute("Contact", contact);
			
	}
	conn.close();
	response.sendRedirect("Details.jsp?result=success");
	}
	
	
	
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			try{
			response.sendRedirect("Details.jsp?result=faild");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
	}
	
	
	
}