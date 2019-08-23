package com.lxisoft.Contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.Contact.repositoryImpl.RepositoryImpl;

@WebServlet("/email")
public class UpEmailid extends HttpServlet {
	
	RepositoryImpl ri = new RepositoryImpl();
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		try {
			String b=req.getParameter("Email");
			String d=req.getParameter("Updated Mail");
			String c="email";
			ri.updateContact(c,b,d);
			res.setContentType("text/html");
    		PrintWriter out = res.getWriter();
      		out.println("<h1>" + "Updated Email Id" + "</h1>");
      		out.println("<a href="+"View.jsp"+">back to jsp</a>");
		}
			
			
		catch(Exception e)
		{
			
		}
	}
}