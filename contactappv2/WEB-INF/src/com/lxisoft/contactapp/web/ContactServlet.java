package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class ContactServlet extends HttpServlet{
	
	ContactService contactService = new ContactService();
	ArrayList<Contact> contactList;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	contactList=contactService.getContactList();
	
	//request.setAttribute("contactList", contactList);
	//request.getRequestDispatcher("ViewContacts.jsp").forward(request, response);
	out.println("<html>"+"<head>"+"<title> Contacts </title>");
	out.println("<style> ");
	out.println("table,th,td{");
	out.println("border: 1px solid black;");
	out.println("</style>"+"</head>"+"<body bgcolor='cyan'>"+"<h1><i>Contacts</h1>"+"<table>");
	out.println("<tr>"+"<th>Name</th>"+"<th>Number</th>"+"</tr>");
	
	for(Contact contact:contactList){
		out.println("<tr>");
		out.println("<td>"+contact.getName()+"</td>");
		out.println("<td>"+contact.getNumber()+"</td>");
		out.println("</tr>");
	}
	out.println("</table>"+"</body>"+"</html>");
	out.close();
	}	

	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
	{
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter();
	System.out.println("@@@@@@@@@@@@@@@addContact");
	String name=request.getParameter("name"); 
	String phone=request.getParameter("phone"); 
	String number=request.getParameter("number");  
	String email=request.getParameter("email");  
	String result = contactService.save(name,phone,number,email);
	HttpSession session = request.getSession();
	System.out.println(result);
	session.setAttribute("result", result);
    RequestDispatcher rd= request.getRequestDispatcher("AddContact.jsp");
    rd.forward(request, response);
	//response.sendRedirect("/contactappv2/Home.jsp");
	out.close();
	}
	
}