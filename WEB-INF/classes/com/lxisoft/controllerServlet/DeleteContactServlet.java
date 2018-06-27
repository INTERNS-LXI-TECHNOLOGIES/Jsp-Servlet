package com.lxisoft.controllerServlet;
import java.io.*;
import com.lxisoft.controller.*;
import com.lxisoft.model.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import java.util.*;

public class DeleteContactServlet extends HttpServlet
{
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		 
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		try
		{
			String name=request.getParameter("name");
			String place=request.getParameter("place");
			String phone=request.getParameter("phoneNumber");
			String email=request.getParameter("email");
			Contact c=new Contact();
			c.setName(name);
			c.setPlace(place);
			c.setPhoneNumber(phone);
			c.setEmail(email);
			ContactController contactController = new ContactController();
			int res=contactController.deleteContact(c);
			Set<Contact> contacts=contactController.viewContact();
			request.setAttribute("cont",contacts);
			RequestDispatcher rd=request.getRequestDispatcher("viewContact.jsp");
			rd.forward(request,response);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}