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
	ArrayList<String> list;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String name=request.getParameter("name");
		list=service.searchContact(name);
		request.setAttribute("list",list);
		RequestDispatcher rd= request.getRequestDispatcher("Search.jsp");
		rd.forward(request, response);
	
		
	}

}