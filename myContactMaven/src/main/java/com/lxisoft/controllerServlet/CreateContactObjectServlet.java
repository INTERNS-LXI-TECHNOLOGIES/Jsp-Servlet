package com.lxisoft.controllerServlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import com.lxisoft.controller.ContactController;
import com.lxisoft.model.Contact;
import org.apache.log4j.Logger;

/**
*Used to control creating contact object for keeping mvc pattern.
*'LOGGER' is a object of Logger class to give logs.
@author ruhail.
@since 16-07-2018.
@version
*/
public class CreateContactObjectServlet extends HttpServlet
{
	private static final Logger LOGGER=Logger.getLogger(CreateContactObjectServlet.class.getName());
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
	/**
	*create contact object with no values.
	*redirect to contact UI form.
	@param request and response.
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		try
		{
			LOGGER.info("started creating null contact");
			Contact contact=new Contact();
			contact.setName("");
			contact.setPlace("");
			contact.setPhoneNumber("");
			contact.setEmail("");
			HttpSession session=request.getSession();
			session.setAttribute("contactSession",contact);
			LOGGER.info("completed creating contact with no values");
			response.sendRedirect("addContact.jsp");
		}
		catch(IOException ex)
		{
			
		}
	}
}