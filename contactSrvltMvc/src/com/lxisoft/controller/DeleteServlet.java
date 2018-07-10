package com.lxisoft.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;

public class DeleteServlet extends HttpServlet{
	
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response ){
		String name=request.getParameter("name");
	
		try{
			Connection conn = null;
			Statement stmt = null;
			
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");
				stmt = conn.createStatement();
				
				//List<Contact> contacts = new ArrayList<Contact>();
			String sql = "DELETE FROM contable where name='"+name+"'";
		  // ResultSet rs = null;
			int rs = stmt.executeUpdate(sql);
			
		  
		  conn.close();
		  response.sendRedirect("Delete.jsp?result=success");
		}catch(Exception e){
			
			System.out.println(e);
			try{
			response.sendRedirect("Delete.jsp?result=failed");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response ){
		
		try{
			Connection conn = null;
			Statement stmt = null;
			
			
		
		String name=(String)request.getSession().getAttribute("i");
		String phone=(String)request.getSession().getAttribute("j");
		String place=(String)request.getSession().getAttribute("k");
		String email=(String)request.getSession().getAttribute("l");
		String oldName=(String)request.getSession().getAttribute("m");

			
			
			
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");
				stmt = conn.createStatement();
				
				String sql = "UPDATE contable SET name='"+name+"', phoneNumber='"+phone+"',place='"+place+"',emailID='"+email+"' where name='"+oldName+"'";
				int	rs = stmt.executeUpdate(sql);
				
				 conn.close();
		  response.sendRedirect("Contact.jsp?result=success");
				
		}
		catch(Exception e){
			System.out.println(e);
			try{
			response.sendRedirect("Contact.jsp?result=failed");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
	}
	
}