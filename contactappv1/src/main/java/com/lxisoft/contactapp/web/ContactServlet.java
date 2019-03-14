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
	
	ContactService contactService = new ContactService();
	ArrayList<Contact> contactList;
	static Logger LOGGER=Logger.getLogger(ContactServlet.class.getName());
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	try{
		LOGGER.info("entering the method");
		FileHandler fh;
		try{
			fh=new FileHandler("C:/Users/Windows 10/Desktop/000-workspace/Team3/contactApp/src/main/webapp/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			
	response.setContentType("text/html"); 
	System.out.println("@@@@@@@@@@@@@@@addContact");
	String first_Name=request.getParameter("first_Name"); 
	String last_Name=request.getParameter("last_Name"); 
	String phone=request.getParameter("phone"); 
	String number=request.getParameter("number");  
	String email=request.getParameter("email");
	LOGGER.info(">Got values ");
	Contact contact=new Contact(first_Name,last_Name,phone,number,email);
	String result = contactService.addContact(contact);
	HttpSession session=request.getSession();
	session.setAttribute("result", result);
    RequestDispatcher rd= request.getRequestDispatcher("AddContact.jsp");
    rd.forward(request, response);
		}
		catch(SQLException e){e.printStackTrace();
		}
	}
	catch(Exception e){
		LOGGER.info("exception catching");
		
		System.out.println(e);
}
	}
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		try{
			
			contactList=contactService.getContact();
			request.setAttribute("contactList",contactList);
			RequestDispatcher rd= request.getRequestDispatcher("ContactDetails.jsp");
			rd.forward(request, response);
			
		}		
		catch(SQLException s){
			s.printStackTrace();
		}
	}
	
}