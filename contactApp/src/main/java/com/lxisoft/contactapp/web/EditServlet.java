package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class EditServlet extends HttpServlet{

		ContactService contactService = new ContactService();
		ArrayList<Contact> list;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			list=contactService.getContact();
			String editName=request.getParameter("editName");
			if(editName!=null){
					request.setAttribute("list",list);
					request.setAttribute("editName",editName);
					RequestDispatcher rd= request.getRequestDispatcher("EditContact1.jsp");
					rd.forward(request, response);}
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