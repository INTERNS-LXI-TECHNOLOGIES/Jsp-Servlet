package com.lxisoft.controller;
import com.lxisoft.contact.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*; 

public class ContactDeleteServlet extends HttpServlet
{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IOException
	{
		try
		{
			res.setContentType("text/html");
			PrintWriter pw=res.getWriter();

			int id=Integer.parseInt(req.getParameter("id"));
			RepoImpl repoImpl=new RepoImpl();
			repoImpl.deleteContact(id);

			pw.println("<html><body>");
			pw.println("Contact Deleted Succesfully");  
			pw.println("</body></html>");  
				  
			pw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
} 