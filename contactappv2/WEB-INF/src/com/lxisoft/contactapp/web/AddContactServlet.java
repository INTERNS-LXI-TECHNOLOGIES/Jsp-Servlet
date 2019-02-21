package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

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

	
	
	//contactService.save(name,phone,number,email);
	//response.sendRedirect("/contactappv2/Home.jsp");
	out.close();
	}
	
}