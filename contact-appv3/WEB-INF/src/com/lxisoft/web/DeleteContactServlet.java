package com.lxisoft.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.sql.SQLException;
import javax.servlet.annotation.WebServlet;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.Contact;

public class DeleteContactServlet extends HttpServlet{

	ContactService service=new ContactService();
	ArrayList<Contact> contactList;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		try{
			String name=request.getParameter("name");
			String result=service.removeContact(name);
			HttpSession session = request.getSession();
			session.setAttribute("result", result);
		    RequestDispatcher rd= request.getRequestDispatcher("Deletecontact.jsp");
		    rd.forward(request, response);
		}
		catch(SQLException s){

			s.printStackTrace();
		}

	}

}
