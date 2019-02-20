package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;
import java.util.ArrayList;

public class AddContactServlet extends HttpServlet{
	
	ContactService contactService = new ContactService();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);

	
	}	

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
	
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter();
  
	System.out.println("@@@@@@@@@@@@@@@addContact");
	String name=request.getParameter("userName"); 
	String phone=request.getParameter("phone"); 
	String number=request.getParameter("phNumber");  
	String email=request.getParameter("userEmail");  
	
	//contact.setEmail(email);
	//contact.setUserPhone(phone);
	contactService.save(name,phone,number,email);
	}
	
}