package com.lxisoft.contactapp.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.contactapp.model.Contact;
import com.lxisoft.contactapp.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class DeleteServlet extends HttpServlet{
	
	ContactService contactService = new ContactService();
	ArrayList<Contact> contactList=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
		String name=request.getParameter("dName");		
		if(name!=null){
					String result=contactService.remove(name);
					HttpSession session = request.getSession();
					session.setAttribute("result", result);
					RequestDispatcher rd= request.getRequestDispatcher("DeleteContact.jsp");
					rd.forward(request, response);
				}
		}catch(SQLException se){
			se.printStackTrace();
		}
		}	
	
}