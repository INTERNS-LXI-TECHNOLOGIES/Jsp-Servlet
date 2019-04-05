package com.lxisoft.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.sql.SQLException;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.Contact;

public class DeleteContactServlet extends HttpServlet{

	static Logger LOGGER=Logger.getLogger(DeleteContactServlet.class.getName());
	private static final long serialVersionUID = 1L;
	ContactService service=new ContactService();
	ArrayList<Contact> contactList;
	
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		LOGGER.info("entering the method");
		FileHandler fh;
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			String name=request.getParameter("id");
			String result=service.removeContact(name);
			LOGGER.info(">Delete Contact");
			HttpSession session = request.getSession();
			session.setAttribute("result", result);
		    RequestDispatcher rd= request.getRequestDispatcher("Home.jsp");
		    rd.forward(request, response);
		}
		catch(SQLException s){
			LOGGER.info(">Catching Exception ");
			s.printStackTrace();
		}

	}

}
