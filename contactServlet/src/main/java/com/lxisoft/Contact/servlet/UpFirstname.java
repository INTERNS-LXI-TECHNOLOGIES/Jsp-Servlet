package com.lxisoft.Contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.Contact.model.ContactModel;
import com.lxisoft.Contact.repositoryImpl.RepositoryImpl;



@WebServlet("/update")
public class UpFirstname extends HttpServlet {
	ArrayList<ContactModel> contacts = new ArrayList <ContactModel>();
	RepositoryImpl ri = new RepositoryImpl();
	
	int count = 0;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		try {
			String b=req.getParameter("First Name");
			String d=req.getParameter("Updated Name");
			String c="firstName";
			ri.updateContact(c,b,d);
		
    		PrintWriter out = res.getWriter();
      		out.println("<h1>" + "Updated" + "</h1>");
      		out.println("<a href="+"View.jsp"+">back to jsp</a>");
		}
			
			
		catch(Exception e)
		{
			
		}
	}
}


