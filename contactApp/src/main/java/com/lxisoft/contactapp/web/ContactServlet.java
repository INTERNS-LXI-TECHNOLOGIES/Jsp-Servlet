package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*;

import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;

import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.servlet.RequestDispatcher;

public class ContactServlet extends HttpServlet{
	
	static Logger LOGGER=Logger.getLogger(ContactServlet.class.getName());
	ContactService contactService = new ContactService();
	ArrayList<Contact> contactList=null;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LOGGER.info("entering the method");
		FileHandler fh;
		try{
			fh=new FileHandler("C:/Users/Windows 10/Desktop/000-workspace/Team3/contactApp/src/main/webapp/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			
			contactList=contactService.getContact();
			LOGGER.info(">Got All Contacts ");
			request.setAttribute("contactList",contactList);
			RequestDispatcher rd= request.getRequestDispatcher("ContactDetails.jsp");
			rd.forward(request, response);
		}
		catch(Exception e){
			LOGGER.info("exception catching");
			
			System.out.println(e);
	}
	}	

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
		LOGGER.info("entering the method");
		FileHandler fh;
		try{
			fh=new FileHandler("C:/Users/Windows 10/Desktop/000-workspace/Team3/contactApp/src/main/webapp/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);

	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter();
	System.out.println("@@@@@@@@@@@@@@@addContact");
	String name=request.getParameter("name"); 
	String phone=request.getParameter("phone"); 
	String number=request.getParameter("number");  
	String email=request.getParameter("email");  
	LOGGER.info(">Got values ");
	Contact contact=new Contact(name,phone,number,email);
	LOGGER.info(">Create Contact ");
	String result = contactService.addContact(contact);
	HttpSession session = request.getSession();
	session.setAttribute("result", result);
    RequestDispatcher rd= request.getRequestDispatcher("AddContact.jsp");
    rd.forward(request, response);
	out.close();
		}
		catch(Exception e){
			LOGGER.info("exception catching");
			
			System.out.println(e);
	}
	}
}