package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class UpdateServlet extends HttpServlet{
	
	ContactService contactService = new ContactService();
	
	ArrayList<Contact> contactList=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter();
	String deleteName=request.getParameter("deleteName");
	contactList=contactService.getContactList();

	for(Contact con:contactList){
	      		if(con.getName().equals(deleteName)){
					String del=contactService.remove(con.getName());
					request.setAttribute("del", del);
					request.getRequestDispatcher("DeleteContact.jsp").forward(request, response);}
				}
	out.println("<a href='Home.jsp'><img src='/contactappv2/images/homeIcon.ico' height='30' width></a>");
	out.close();
	}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter();
	System.out.println("@@@@@@@@@@@@@@@updateContact");
	String updateName=request.getParameter("updateName"); 
	String updatePhone=request.getParameter("updatePhone"); 
	String updateNumber=request.getParameter("updateNumber");  
	String updateEmail=request.getParameter("updateEmail"); 
	String result = contactService.update(updateName,updatePhone,updateNumber,updateEmail);
	HttpSession session = request.getSession();
	session.setAttribute("result", result);
    RequestDispatcher rd= request.getRequestDispatcher("EditContact.jsp");
    rd.forward(request, response);
	out.close();
	}
}