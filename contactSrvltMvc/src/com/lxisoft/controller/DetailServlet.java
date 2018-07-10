package com.lxisoft.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;

public class DetailServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ){
		String name1=request.getParameter("name");
		
		System.out.println(">>>>>>>>>>"+name1);
		
		try{
			Connection conn = null;
			Statement stmt = null;
			
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");
				stmt = conn.createStatement();
				
				//List<Contact> contacts = new ArrayList<Contact>();
			String sql = "SELECT * FROM contable where name='"+name1+"'";
		   ResultSet rs = null;
		   
		   
			rs = stmt.executeQuery(sql);
			
			while (rs.next()) {
			   String name=rs.getString("name");
			   String phone=rs.getString("phoneNumber");
			   String place=rs.getString("place");
			   String email=rs.getString("emailID");
			  // System.out.println("?????????????????"+name);
			  request.getSession().setAttribute("e",name);
			  request.getSession().setAttribute("f",phone);
			  request.getSession().setAttribute("g",place);
			  request.getSession().setAttribute("h",email);
			   
		   }
			conn.close();
			response.sendRedirect("Details.jsp?result=success");
			
		}
		catch(Exception e){
			
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