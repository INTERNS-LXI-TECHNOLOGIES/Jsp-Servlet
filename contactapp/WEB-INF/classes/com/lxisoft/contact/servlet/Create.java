package com.lxisoft.contact.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import com.lxisoft.contact.model.*;
import com.lxisoft.contact.repo.*;
import java.sql.*;
import java.io.*;
@WebServlet("/create")
public class Create extends HttpServlet
{
	
	public void doPost(HttpServletRequest request,HttpServletResponse res)throws ServletException
	{
		try{
		
		Contact contact=new Contact();
			contact.setName(request.getParameter("Name"));
			contact.setPhoneNumber(request.getParameter("PhoneNumber"));
			System.out.println(request.getParameter("Name")+"*************"+request.getParameter("PhoneNumber"));
			RepositoryImpl repo=new RepositoryImpl();
			repo.create(contact);
			PrintWriter out=res.getWriter();
			out.println("<h1>"+"Created"+"</h1>");
			out.println("<a href="+"create.jsp"+">back to jsp</a>");
		}
		catch(Exception e){//System.out.println(e);
	e.printStackTrace();}
		
	}
	
	
}