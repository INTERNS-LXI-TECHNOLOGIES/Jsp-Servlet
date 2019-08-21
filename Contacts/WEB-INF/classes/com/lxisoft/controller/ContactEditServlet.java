package com.lxisoft.controller;
import com.lxisoft.contact.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;

public class ContactEditServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();

			Contact contact=new Contact();
			int id=Integer.parseInt(req.getParameter("id"));
			contact.setName(req.getParameter("Name"));
			contact.setNumber(req.getParameter("ContactNumber"));
		
			RepoImpl repoImpl=new RepoImpl();
			repoImpl.updateContact(id,contact);

			pw.println("<html><body>");
			pw.println("Contact Updated Succesfully");  
			pw.println("</body></html>");  
				  
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
} 