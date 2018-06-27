package com.lxisoft.controllerServlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import com.lxisoft.controller.ContactController;

public class AddContactServlet extends HttpServlet
{
	ContactController contactController=new ContactController();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		String name=request.getParameter("name");
		String place=request.getParameter("place");
		String phoneNumber=request.getParameter("phoneNumber");
		String email=request.getParameter("email");
		int res=contactController.addContact(name,place,phoneNumber,email);
		if(res>0)
		{
			response.sendRedirect("addContact.jsp?success");
		}
		else
		{
			response.sendRedirect("addContact.jsp?failed");
		}
	}
	public void doget(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
}