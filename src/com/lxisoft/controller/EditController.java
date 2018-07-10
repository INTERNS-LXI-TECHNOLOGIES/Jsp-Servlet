package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class EditController extends HttpServlet{
	

public void doPost(HttpServletRequest request,HttpServletResponse response){
	System.out.println("edit is working");
	//Contact contact=(Contact)request.getSession().getAttribute("contact");
	try{
		
        String name=request.getParameter("name"); 
		String phone=request.getParameter("phone");
		String oldName=request.getParameter("oldName"); 
		System.out.println(" "+name);
		System.out.println(" "+phone);
		System.out.println(" "+oldName);
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactssvlt", "root", "root");

		stmt = conn.createStatement();
		String sql = "update contactss set name='"+name+"',phone='"+phone+"' where name='"+oldName+"'";
	
		//out.println("Do you want to update this entry");
		int rs=stmt.executeUpdate(sql);
		
		
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