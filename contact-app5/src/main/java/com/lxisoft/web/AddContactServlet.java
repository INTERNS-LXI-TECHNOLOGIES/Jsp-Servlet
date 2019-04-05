package com.lxisoft.web;
import javax.servlet.*;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.Contact;
import java.sql.SQLException;

public class AddContactServlet extends HttpServlet{
	
	

    static final Logger logger = Logger.getLogger(AddContactServlet.class);
	private static final long serialVersionUID = 1L;
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
			 BasicConfigurator.configure();
			 
		     logger.debug("contact added");
			session.setAttribute("result", result);
		    RequestDispatcher rd= request.getRequestDispatcher("AddContact.jsp");
		    rd.forward(request, response);
		}
		catch(SQLException s){
			s.printStackTrace();
		}

	}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		int count = 0;
		ArrayList<Contact> contactListP = new ArrayList<Contact>();
		try{
			contactList=service.getContact();
		} 
		catch(SQLException s){
		
			s.printStackTrace();
		}

		
			if(request.getParameter("prev")!= null) {
				if(count!=0) {
					count = count - 5;
				}
			}
			if(request.getParameter("next")!= null) {
				if(count<contactList.size()-5) {
					count = count + 5;
				}
			}
			for(int i = count;i<(count+5);i++) {
				if(i<contactList.size()) {
				contactListP.add(contactList.get(i));
				}
			}
			request.setAttribute("contactList",contactListP);
			
			RequestDispatcher rd= request.getRequestDispatcher("contact.jsp");
			rd.forward(request,response);
		
		

	}
}
