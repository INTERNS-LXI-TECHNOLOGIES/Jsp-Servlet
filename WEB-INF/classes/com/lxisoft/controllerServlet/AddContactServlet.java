package com.lxisoft.controllerServlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import com.lxisoft.controller.ContactController;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import com.lxisoft.model.*;

public class AddContactServlet extends HttpServlet
{
	private static final Logger LOGGER=Logger.getLogger(AddContactServlet.class.getName());
	ContactController contactController=new ContactController();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		LOGGER.info("------add contact servlet doPost started------");
		HttpSession session=request.getSession();
		Contact c=(Contact)session.getAttribute("contactSession");
		String name=request.getParameter("name");
		c.setName(name);
		String place=request.getParameter("place");
		c.setPlace(place);
		String phoneNumber=request.getParameter("phoneNumber");
		c.setPhoneNumber(phoneNumber);
		String email=request.getParameter("email");
		c.setEmail(email);
		int res=contactController.addContact(c);
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