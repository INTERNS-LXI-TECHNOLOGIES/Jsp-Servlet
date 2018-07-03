package com.lxisoft.controllerServlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import com.lxisoft.controller.ContactController;
import java.util.logging.Logger;

public class AddContactServlet extends HttpServlet
{
	private static final Logger LOGGER=Logger.getLogger(AddContactServlet.class.getName());
	ContactController contactController=new ContactController();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		LOGGER.info("------add contact servlet doPost started------");
		String name=request.getParameter("name");
		String place=request.getParameter("place");
		String phoneNumber=request.getParameter("phoneNumber");
		String email=request.getParameter("email");
		int res=contactController.addContact(name,place,phoneNumber,email);
		if(res>0)
		{
			LOGGER.info("------add contact servlet doPost completed------");
			response.sendRedirect("addContact.jsp?success");
		}
		else
		{
			LOGGER.info("------add contact servlet doPost completed------");
			response.sendRedirect("addContact.jsp?failed");
		}
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
}