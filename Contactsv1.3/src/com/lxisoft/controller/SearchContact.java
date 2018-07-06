package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class SearchContact extends HttpServlet{

	public void doGet(HttpServletRequest request,HttpServletResponse response)
	{
		System.out.println("#########################searchContact//get working");
		try{
		Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contactWebApp","root","root");
			Statement statement=connection.createStatement();
				String sid=request.getParameter("id");
				System.out.println("get/sid="+sid);
				if(sid==null)
				{
					System.out.println(">>>>>>>>>> get/first if  working");
					ResultSet resultSet=statement.executeQuery("select * from contacts");
					ArrayList<Contact>contacts=new ArrayList<Contact>();
					
					while(resultSet.next())
					{
						contacts.add(new Contact(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3)));
						
					}
					
					request.getSession().setAttribute("contacts",contacts);
					response.sendRedirect("Contacts.jsp");
				}
				else
				{
					System.out.println("#########################get/second else working");
					ResultSet resultSet=statement.executeQuery("select * from contacts where id="+request.getParameter("id"));
					ArrayList<Contact>contacts=new ArrayList<Contact>();
					whileLoop:
					while(resultSet.next())
					{
						Contact contact=new Contact(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
						int id=Integer.valueOf(request.getParameter("id"));
						if(resultSet.getInt(1)==id)
						{
							request.getSession().setAttribute("contact",contact);
							break whileLoop;
						}
						
					}
					response.sendRedirect("Details.jsp");
					
				}
				connection.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
			
	}
}	