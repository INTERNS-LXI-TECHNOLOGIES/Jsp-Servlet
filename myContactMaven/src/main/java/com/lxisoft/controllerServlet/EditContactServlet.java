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
*Used to control edit contact in database.
*'LOGGER' is a object of Logger class to give logs.
@author ruhail.
@since 16-07-2018.
@version
*/
public class EditContactServlet extends HttpServlet
{
	private static final Logger LOGGER=Logger.getLogger(EditContactServlet.class.getName());
	/**
	*calling viewContact and deleteContact methods for viewing and deleting contact object.
	*redirect to view contact UI page.
	@param request and response.
	*/
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		try
		{
			LOGGER.info("------edit contact servlet doPost started------");
			String hidName=request.getParameter("nameHidden");
			String name=request.getParameter("name");
			String place=request.getParameter("place");
			String phone=request.getParameter("phoneNumber");
			String email=request.getParameter("email");
			ContactController contactController = new ContactController();
			Contact contact=new Contact();
			contact.setName(name);
			contact.setPlace(place);
			contact.setPhoneNumber(phone);
			contact.setEmail(email);
			int res=contactController.editContact(contact,hidName);
			Set<Contact> contacts=contactController.viewContact();
			request.setAttribute("cont",contacts);
			RequestDispatcher rd=request.getRequestDispatcher("viewContact.jsp");
			LOGGER.info("------edit contact servlet doPost completed------");
			rd.forward(request,response);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		 
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
}