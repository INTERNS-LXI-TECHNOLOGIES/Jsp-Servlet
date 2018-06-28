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
import java.util.logging.Logger;

public class SearchContactServlet extends HttpServlet
{
	private static final Logger LOGGER = Logger.getLogger(SearchContactServlet.class.getName());
	ContactController contactController=new ContactController();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
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
}