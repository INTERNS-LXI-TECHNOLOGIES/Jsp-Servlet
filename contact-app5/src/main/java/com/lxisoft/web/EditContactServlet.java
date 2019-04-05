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

public class EditContactServlet extends HttpServlet{
	
	static Logger LOGGER=Logger.getLogger(EditContactServlet.class.getName());
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
			String name1=request.getParameter("id");
			list=service.searchContact(name1);
			LOGGER.info(">Edit Contact");
			request.setAttribute("list",list);
			request.setAttribute("name1",name1);
			RequestDispatcher rd= request.getRequestDispatcher("editpage.jsp");
			rd.forward(request, response);
		}
		 catch(SQLException s){
		    	s.printStackTrace();
		    }
	}
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
			LOGGER.info("entering the method");
			FileHandler fh;
			try{
				fh=new FileHandler("D:/Project/tomcat/webapps/contact-app/WEB-INF/classes/logWork");
				LOGGER.addHandler(fh);
				SimpleFormatter formatter=new SimpleFormatter();
				fh.setFormatter(formatter);
				String upName=request.getParameter("name");
				String upPhno=request.getParameter("phno");
				String uName=request.getParameter("sname");
				String result=service.editContact(uName,upName,upPhno);
				LOGGER.info(">Update Contact");
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