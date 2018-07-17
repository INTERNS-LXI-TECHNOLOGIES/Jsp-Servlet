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
import org.apache.log4j.Logger;
/**
*Used to control delete contact from database.
*'LOGGER' is a object of Logger class to give logs.
@author ruhail.
@since 16-07-2018.
@version
*/
public class DeleteContactServlet extends HttpServlet
{
	private static final Logger LOGGER = Logger.getLogger(DeleteContactServlet.class.getName());
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		 
	}
	/**
	*calling viewContact and deleteContact methods for viewing and deleting contact object.
	*redirect to view contact UI page.
	@param request and response.
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		try
		{
			LOGGER.info("------delete contact servlet doPost started------");
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
			LOGGER.info("------delete contact servlet doPost completed------");
			rd.forward(request,response);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}