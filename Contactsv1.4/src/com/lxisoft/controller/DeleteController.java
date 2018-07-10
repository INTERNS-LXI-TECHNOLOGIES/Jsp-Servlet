package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class DeleteController extends HttpServlet{

public void doGet(HttpServletRequest request, HttpServletResponse response){
	System.out.println("DDDDDDDDDDDDDDD delete working");
		int id=((Contact) request.getSession().getAttribute("contact")).id;
		request.getSession().removeAttribute("contact");
		System.out.println("DDDDDDDDDDDDDDD delete/id= "+id);
		try{
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
			Statement statement=connection.createStatement();
			statement.execute("delete from contacts where id="+id);
			connection.close();
			response.sendRedirect("Delete.jsp");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}