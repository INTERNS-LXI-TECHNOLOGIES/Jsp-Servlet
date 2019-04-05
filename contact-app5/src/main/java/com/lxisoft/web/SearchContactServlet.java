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

public class SearchContactServlet extends HttpServlet{

	static Logger LOGGER=Logger.getLogger(SearchContactServlet.class.getName());
	private static final long serialVersionUID = 1L;
	ContactService service=new ContactService();
	ArrayList<Contact> contactList;
	ArrayList<String> list;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		LOGGER.info("entering the method");
		FileHandler fh;
		try{
			fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
			LOGGER.addHandler(fh);
			SimpleFormatter formatter=new SimpleFormatter();
			fh.setFormatter(formatter);
			String name=request.getParameter("name");
			list=service.searchContact(name);
			LOGGER.info(">Search Contact");
			request.setAttribute("list",list);
			RequestDispatcher rd= request.getRequestDispatcher("Search.jsp");
			rd.forward(request, response);
		}
		catch(SQLException s){
			LOGGER.info(">Catching Exception ");
			s.printStackTrace();
		}
		
	}

}