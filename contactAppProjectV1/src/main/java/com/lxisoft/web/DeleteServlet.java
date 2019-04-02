package com.lxisoft.web;

import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.model.Contact;
import com.lxisoft.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;



public class DeleteServlet extends HttpServlet{

	
	ContactService contactService = new ContactService();
	ArrayList<Contact> contactList=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		try{
			String name = request.getParameter("id");
					
		if(name!=null){
					String result=contactService.remove(name);
					System.out.println(result);
					RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
					rd.forward(request, response);
	
				}
		}catch(SQLException se){
			se.printStackTrace();
		}
		}	
	
}