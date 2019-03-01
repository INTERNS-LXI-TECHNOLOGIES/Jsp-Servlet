package com.lxisoft.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.Contact;
import java.sql.SQLException;

public class AddContactServlet extends HttpServlet{

	ContactService service=new ContactService();
	ArrayList<Contact> contactList;
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		try{
			String name=request.getParameter("name");
			String phno=request.getParameter("phno");
			Contact contact=new Contact(name,phno);
			String result = service.addContact(contact);
			HttpSession session = request.getSession();
			session.setAttribute("result", result);
		    RequestDispatcher rd= request.getRequestDispatcher("Addcontact.jsp");
		    rd.forward(request, response);
		}
		catch(SQLException s){
			s.printStackTrace();
		}

	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		try{
			contactList=service.getContact();
			System.out.println(contactList);
			request.setAttribute("contactList",contactList);
			RequestDispatcher rd= request.getRequestDispatcher("contact.jsp");
			rd.forward(request, response);
		} 
		catch(SQLException s){
			s.printStackTrace();
		}

	}
}
