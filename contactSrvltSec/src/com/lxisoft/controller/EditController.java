package com.lxisoft.controller;
import com.lxisoft.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import java.util.*;

public class EditController extends HttpServlet{
public void doGet(HttpServletRequest request,HttpServletResponse response){
	System.out.println("get/search is working");
	String getName=request.getParameter("name");
	Connection conn = null;
	Statement stmt = null;
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");

		stmt = conn.createStatement();
		String sql = "select * from contable where name='"+getName+"'";
		
		ResultSet rs = null;	
		rs = stmt.executeQuery(sql);
	
	while (rs.next()) {
			Contact contact =new Contact(rs.getString("name"),rs.getString("phoneNumber"),rs.getString("place"),rs.getString("emailID"));
			
			request.getSession().setAttribute("Contact", contact);
			
	}
	conn.close();
	response.sendRedirect("Edit.jsp?result=success");
	}
	
	
	
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			try{
			response.sendRedirect("Edit.jsp?result=faild");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
	}
}
	
	