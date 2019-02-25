package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class DeleteServlet extends HttpServlet{
	
	ContactService contactService = new ContactService();
	
	ArrayList<Contact> contactList=null;
	ArrayList<Contact> con=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter();
	String deleteName=request.getParameter("deleteName");
	out.println(deleteName);
	contactList=contactService.getContactList();
	for(Contact contact:contactList){
	      		if(contact.getName().equals(deleteName)){
					String delete=contactService.removeContact(deleteName);
					out.println(delete);
				}
	}
	
	}
	
}