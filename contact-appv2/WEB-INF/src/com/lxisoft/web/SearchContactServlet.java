package com.lxisoft.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.Contact;

public class SearchContactServlet extends HttpServlet{

	ContactService service=new ContactService();
	ArrayList<Contact> contactList;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		
		PrintWriter out=response.getWriter();
		out.println("<html>"+"<head>"+"<title>Contact List</title>");
		out.println("</head>"+"<body bgcolor=#98FB98>"+"<a href=Home.jsp>Home</a>"+"<center>"+"<h1>Contact Number</h1>");
		out.println("<form method=get action=SearchContact>"+"Name :<input type=text name=name><br><br>");
		out.println("<button type=submit><image src=data/search.jpg height=30px width=30px></button>"+"</form>"+"</center>");
		
		String name=request.getParameter("name");
		String phno=service.searchContact(name);

		out.println("<center>"+name+"  "+phno+"</center>");
		out.println("</body>"+"</html>");
	}

}