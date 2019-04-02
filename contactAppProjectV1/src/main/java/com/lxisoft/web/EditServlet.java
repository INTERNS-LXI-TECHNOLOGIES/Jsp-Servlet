package com.lxisoft.web;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.http.*; 
import com.lxisoft.model.Contact;
import com.lxisoft.service.ContactService;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

public class EditServlet extends HttpServlet{

		ContactService contactService = new ContactService();
		ArrayList list;
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {
		try{
			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter();
			System.out.println("@@@@@@@@@@@@@@@updateContact");
			String uFirstName=request.getParameter("uFirstName");
			String uLastName=request.getParameter("uLastName");	
			String uPhone=request.getParameter("uPhone"); 
			String uNumber=request.getParameter("uNumber");  
			String uEmail=request.getParameter("uEmail"); 
			System.out.println(uFirstName+" "+uLastName+" "+" "+uPhone+" "+" "+uNumber+" "+" "+uEmail+" ");
			String result = contactService.updateContact(uFirstName,uLastName,uPhone,uNumber,uEmail);
			
			HttpSession session = request.getSession();
			session.setAttribute("result", result);
			RequestDispatcher rd= request.getRequestDispatcher("EditContact1.jsp");
			rd.forward(request, response);
			out.close();
			}catch(SQLException se){
			se.printStackTrace();}
	}
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

			
			 String contact = (String)request.getParameter("id");
			try {
				list = contactService.searchContactId(contact);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
					request.setAttribute("list",list);
					System.out.println(list);
					RequestDispatcher rd= request.getRequestDispatcher("EditContact1.jsp");
					rd.forward(request, response);}
		
}
