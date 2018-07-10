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
	Contact contact=(Contact)request.getSession().getAttribute("contact");
	String name=contact.getName();
	String phone=contact.getPhoneNumber();

	System.out.println("dopost/delete/name"+name);
	System.out.println("dopost/delete/phone"+phone);
	Connection conn = null;
	Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactssvlt", "root", "root");
			stmt = conn.createStatement();
			String sql = "delete from contactss where name='"+name+"'";
			//out.println(" "+sql);
			//ResultSet rs = null;
			//out.println("Do you want to delete this entry");
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