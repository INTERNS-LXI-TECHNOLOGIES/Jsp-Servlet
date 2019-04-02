package com.lxisoft.web;
import java.util.List;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.model.Contact;
import com.lxisoft.service.ContactService;
import java.util.ArrayList;

import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;

public class ContactServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ContactService contactService = new ContactService();
	ArrayList<Contact> contactList;
	static Logger LOGGER=Logger.getLogger(ContactServlet.class.getName());
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException{
	try{
	LOGGER.info("entering the method");
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
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

	//	try {
		//	contactList=contactService.getContact();
	//	} catch (SQLException e) {
			// TODO Auto-generated catch block
		//	e.printStackTrace();
	//	}
		
      //   request.setAttribute("contactList", contactList);
 
      //   RequestDispatcher rd= request.getRequestDispatcher("ContactDetails.jsp");
      //   rd.forward(request, response);
	
	//}
	
	int count = 0;
		//ContactRepo contactRepo = new ContactRepo();
		List<Contact> contacts = null;
		List<Contact> contactsp = new ArrayList<Contact>();
		try {
			contacts =contactService.getContact();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		if(request.getParameter("prev")!= null) {
			if(count!=0) {
				count = count - 5;
			}
		}
		if(request.getParameter("next")!= null) {
			if(count<contacts.size()-5) {
				count = count + 5;
			}
		}
		for(int i = count;i<(count+5);i++) {
			if(i<contacts.size()) {
			contactsp.add(contacts.get(i));
			}
		}
		request.setAttribute("contacts",contactsp);
		
		RequestDispatcher reqD = request.getRequestDispatcher("/ContactDetails.jsp");
		reqD.forward(request,response);
	
	}
	
}