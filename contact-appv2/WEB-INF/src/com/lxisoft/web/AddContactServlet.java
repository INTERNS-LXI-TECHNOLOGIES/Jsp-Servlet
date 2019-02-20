package com.lxisoft.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.Contact;
public class AddContactServlet{

	ContactService service;

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String name=request.getParameter("name");
		String phno=request.getParameter("phno");
		Contact contact=new Contact(name,phno);
		service.addContact(contact);

	}
}