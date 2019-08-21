package com.lxisoft.controller;
import com.lxisoft.contact.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

public class ContactServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IndexOutOfBoundsException
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();

			Contact contact=new Contact();
		
			contact.setName(req.getParameter("Name"));
			contact.setNumber(req.getParameter("ContactNumber"));
		
			RepoImpl repoImpl=new RepoImpl();
			int status=repoImpl.createContact(contact);
			if(status!=0)
			{
				HttpSession session=req.getSession();
				//ArrayList<Contact> list=repoImpl.getAllDB();
				session.setAttribute("list",repoImpl.getAllDB());
				res.sendRedirect("response.jsp");
			}
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();

			pw.println("<html><head><title>");
			pw.println("View Page");
			pw.println("</title></head><body><h2>");
			pw.println("Contact List");
			pw.print("</h2><table><tr><th>");
			pw.println("Id.");
			pw.print("</th><th>");
			pw.println("Name");
			pw.print("</th> <th>");
			pw.println("Contact Number");
			pw.println("</th></tr>");
		
				RepoImpl repoImpl=new RepoImpl();
				ArrayList<Contact> contactList=repoImpl.viewContact();
		
				for(int i=0;i<contactList.size();i++)
				{ 
					pw.print("<tr><td>");
					pw.println(contactList.get(i).getId());
					pw.print("</td><td>");
					pw.println(contactList.get(i).getName());
					pw.print("</td><td>");
					pw.println(contactList.get(i).getNumber());
					pw.print("</td></tr>");
			//<!-- System.out.println(contactList.get(i).getId()+"\t"+contactList.get(i).getName()+"\t"+contactList.get(i).getNumber()); -->
		}
		pw.println("</table>");
	//<a href="Home.html">Back to Home</a>
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
} 