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
		ArrayList<Contact> contactList=null;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{

			String editName=request.getParameter("eName");
			if(editName!=null){
				contactList=contactService.getContact();
				for(Contact cont:contactList){
					if(cont.getFirstName().equals(editName)){
					request.setAttribute("eName",editName);
					request.setAttribute("cont",cont);
					RequestDispatcher rd= request.getRequestDispatcher("EditContact1.jsp");
					rd.forward(request, response);}
				}
			}
			}catch(SQLException se){
			se.printStackTrace();
		}
	}
		
		
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		try{
			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter();
			System.out.println("@@@@@@@@@@@@@@@updateContact");
			String oName=request.getParameter("oldName");
			String uFirstName=request.getParameter("uFirstName");
			String uLastName=request.getParameter("uLastName");	
			String uPhone=request.getParameter("uPhone"); 
			String uNumber=request.getParameter("uNumber");  
			String uEmail=request.getParameter("uEmail"); 
			String result = contactService.updateContact(oName,uFirstName,uLastName,uPhone,uNumber,uEmail);
			
			HttpSession session = request.getSession();
			session.setAttribute("result", result);
			RequestDispatcher rd= request.getRequestDispatcher("EditContact.jsp");
			rd.forward(request, response);
			out.close();
			}catch(SQLException se){
			se.printStackTrace();}
	}
}