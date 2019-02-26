package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class SearchServlet extends HttpServlet{
	
	ContactService contactService=new ContactService();
	
	ArrayList<Contact> contactList=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html"); 
	PrintWriter out = response.getWriter();
	HttpSession session = request.getSession();
	contactList=contactService.getContactList();
	out.println("<html>"+"<head>"+"<title> Search Result</title>");
	out.println("<style> ");
	out.println("table,th,td{");
	out.println("border: 1px solid black;");
	out.println("</style>"+"</head>"+"<body bgcolor='cyan'>"+"<h1><i>Contacts</h1>"+"<table>");
	out.println("<tr>"+"<th>Name</th>"+"<th>Number</th>"+"</tr>");
	
	String searchName=request.getParameter("searchName");
	for(int i=0;i<contactList.size();i++){
	      		if(contactList.get(i).getName().contains(searchName)){
					out.println("<tr>");
					out.println("<td>"+contactList.get(i).getName()+"</td>");
					out.println("<td>"+contactList.get(i).getNumber()+"</td>");	
					out.println("</tr><br><br>");
	      		}		
	}
	searchName=" ";
	out.println("</table>"+"</body>"+"</html>");
	out.println("<a href='Home.jsp'><img src='/contactappv2/images/homeIcon.ico' height='30' width></a>");
	out.close();
	}
}