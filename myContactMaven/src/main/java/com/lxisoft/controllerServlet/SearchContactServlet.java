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
*Used to control search contact in database.
*'LOGGER' is a object of Logger class to give logs.
@author ruhail.
@since 16-07-2018.
@version
*/
public class SearchContactServlet extends HttpServlet
{
	private static final Logger LOGGER = Logger.getLogger(SearchContactServlet.class.getName());
	ContactController contactController=new ContactController();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
	/**
	*calling search methods for searching and viewing contact object.
	*redirect to view contact UI page.
	@param request and response.
	*/
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		try
		{
			LOGGER.info("------search contact servlet doPost started------");
			String searchValue=request.getParameter("search");
			ContactController contactController=new ContactController();
			Set<Contact> c=contactController.searchContact(searchValue);
			request.setAttribute("contacts",c);
			RequestDispatcher rd=request.getRequestDispatcher("searchContact.jsp");
			LOGGER.info("------search contact servlet doPost completed------");
			rd.forward(request,response);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
}