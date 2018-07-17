package com.lxisoft.controllerServlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import com.lxisoft.controller.ContactController;
import java.util.*;
import com.lxisoft.model.*;
import org.apache.log4j.Logger;
/**
*Used to control reading data from database to exhibit in UI.
*'LOGGER' is a object of Logger class to give logs.
@author ruhail.
@since 16-07-2018.
@version
*/
public class ViewContactServlet extends HttpServlet
{
	private static final Logger LOGGER = Logger.getLogger(ViewContactServlet.class.getName()); 
	ContactController contactController=new ContactController();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
	/**
	*calling viewContact() method of ContactController class.
	*send read data to UI to display using RequestDispatcher.
	@param request and response.
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		try
		{
			LOGGER.info("------view contact servlet doPost started------");
			ContactController cont=new ContactController();
			Set<Contact> contacts=cont.viewContact();
			request.setAttribute("cont",contacts);
			RequestDispatcher rd=request.getRequestDispatcher("viewContact.jsp");
			LOGGER.info("------view contact servlet doPost completed------");
			rd.forward(request,response);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}