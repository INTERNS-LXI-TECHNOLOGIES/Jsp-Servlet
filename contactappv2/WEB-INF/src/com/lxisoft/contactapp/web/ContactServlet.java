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
	ArrayList<Contact> conList;
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String editName=request.getParameter("editName");
		HttpSession session = request.getSession();
		contactList=contactService.getContactList();
		for(Contact cont:contactList){
			if(cont.getName().equals(editName)){
				out.print("<form action='Update' method='post'>");
				out.println("<style> ");
				out.println("table,th,td{");
				out.println("border: 1px solid black;");
				out.println("</style>"+"</head>"+"<body bgcolor='cyan'>"+"<h1><i>Contacts</h1>"+"<table>");
				out.print("<tr><td>Name:<input type='text' name='updateName' value='"+cont.getName()+"'/></td></tr>");
				out.print("<tr><td>Phone:");
				out.print("<select name='updatePhone'>");
				out.print("<option>Land-Line</option>");
				out.print("<option>Mobile</option>");
				out.print("<option>Other</option>");
				out.print("</select>");
				out.print("</td></tr>");
				out.print("<tr><td>Number:<input type='tel' name='updateNumber' value='"+cont.getNumber()+"'/></td></tr>");
				out.print("<tr><td>Email:<input type='email' name='updateEmail' value='"+cont.getEmail()+"'/></td></tr>");
				out.print("<tr><td><input type='submit' value='Save'/></td></tr>");
				out.print("</table>");
				out.print("</form>");
			}
		}
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
	session.setAttribute("result", result);
    RequestDispatcher rd= request.getRequestDispatcher("AddContact.jsp");
    rd.forward(request, response);
	out.close();
	}
	
}