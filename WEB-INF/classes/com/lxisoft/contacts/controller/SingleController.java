package com.lxisoft.contacts.controller;

//cd apache-tomcat-7.0.72\webapps\contacts\WEB-INF\classes
//javac -classpath D:\apache-tomcat-7.0.72\lib\servlet-api.jar;D:\apache-tomcat-7.0.72\webapps\contacts\WEB-INF\lib\log4j-api-2.11.0.jar;. com\lxisoft\contacts\controller\SingleController.java
//http://localhost:8080/contacts/index.jsp
//changing 'classes' to 'src' -> problem (war)
//D:\apache-tomcat-7.0.72\webapps\contacts\WEB-INF\classes\log4j2.properties

import java.io.*;
import java.util.*;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lxisoft.contacts.model.*;
import com.lxisoft.contacts.service.*;
import com.lxisoft.contacts.utility.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

/**
* This program gives a hands-on experience on Jsp-Servlet-MySql-FileUtils-DatabaseUtils
*
* @author  Vyshnav Ramesh
* @version 1.0
* @since   2018-06-28 
*/
@WebServlet("/")
public class SingleController extends HttpServlet{
	
	private static final Logger LOGGER = LogManager.getLogger(SingleController.class.getName());
	
	//OVERRIDE INIT METHOD OF GENERICSERVLET
	@Override
	public void init() {
		LOGGER.info("init");
		String url=getServletContext().getInitParameter("url");
		String username=getServletContext().getInitParameter("username");
		String password=getServletContext().getInitParameter("password");
		DatabaseUtils dbUtils = DatabaseUtils.getInstance();
		dbUtils.configure(url,username,password);
	}


	//POST METHOD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LOGGER.info("doPost");
		doGet(request, response);
	}

	//GET METHOD
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		LOGGER.info("doGet");
		String action = request.getServletPath();
		System.out.println(action);
		
		try {
			switch (action) {
				case "/signup":
					signup(request,response);
					break;
				case "/login":
					login(request,response);
					break;
				case "/logout":
					logout(request,response);
					break;
				case "/create":
					createContact(request,response);
					break;
				case "/myContact":
					showMyContactPage(request,response);
					break;
				case "/contacts":
					showContactsPage(request,response);
					break;
				case "/edit":
					editContact(request,response);
					break;
				case "/update":
					updateContact(request,response);
					break;
				case "/delete":
					deleteContact(request,response);
					break;
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	//SIGNUP	
	private void signup(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("signup");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		UserService userService = new UserService();
		boolean userCeated = userService.create(user);
		if(userCeated){
			LOGGER.info("signup successful");
			user = userService.read(username, password);
			request.getSession().setAttribute("userId", user.getUserId());						// 2nd parameter: type Object (mayb auto parsed)
			showCreateContactPage(request, response);
		}else{
			LOGGER.info("signup failed");
		}
			
	}
	
	//LOGIN	
	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("login");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserService();
		User user = userService.read(username, password);
		if(user != null){												
			LOGGER.info("login success");
			request.getSession().setAttribute("userId", user.getUserId());	// 2nd parameter: type Object (mayb auto parsed)
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit_contact.jsp");
			dispatcher.forward(request, response);
		}else{
			LOGGER.info("login failed");
		}	
	}
	
	//LOGOUT	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("logout");
		HttpSession session = request.getSession();
		session.removeAttribute("userId");
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request,response);
	}
	
	//CREATE CONTACT
	private void createContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("create");
		int userId = (int) request.getSession().getAttribute("userId");					
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		Contact contact = new Contact(userId, name, phone);
		ContactService contactService = new ContactService();
		contactService.create(contact);	
		request.setAttribute("contact",contact);
		showMyContactPage(request, response);
		
	}
	
		
	//READ CONTACT
	private Contact readContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("showMyContactPage");
		HttpSession session = request.getSession();
		int userId = (int) request.getSession().getAttribute("userId");	
		ContactService contactService = new ContactService();
		Contact contact = contactService.read(userId);
		return contact;
	}
	
	//READ ALL CONTACTS
	 private List<Contact> readAllContacts() throws SQLException{
		LOGGER.info("readAll");
		ContactService contactService = new ContactService();
		List<Contact> contactList = contactService.readAll();
		return contactList;
	}	
		
	//EDIT CONTACT	
	private void editContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("editContact");
		Contact contact = readContact(request, response);
		request.setAttribute("contact",contact);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit_contact.jsp");
		dispatcher.forward(request,response);
	}	
		
	//UPDATE CONTACT
	private void updateContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("updateContact");
		int userId = (int) request.getSession().getAttribute("userId");	
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		Contact updatedContact = new Contact(userId, name, phone);
		ContactService contactService = new ContactService();
		boolean contactUpdated = contactService.update(updatedContact);	
		if(contactUpdated) {
			LOGGER.info("Contact updated..");
			request.setAttribute("contact",updatedContact);
			showMyContactPage(request, response);
		}else {
	    	LOGGER.info("Contact not updated..");
		}
	
	}
	
	//DELETE CONTACT
	private void deleteContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("deleteContact");
		int userId = (int) request.getSession().getAttribute("userId");	
		ContactService contactService = new ContactService();
		boolean contactdeleted = contactService.delete(userId);	
		if(contactdeleted) {
			LOGGER.info("Contact deleted..");
			showCreateContactPage(request, response);	
		}else {
	    	LOGGER.info("Contact not updated");
		}
	}
	
	//OPEN CONTACTS.JSP
	private void showContactsPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("showContactsPage");
		List<Contact> contactList = readAllContacts();
		request.setAttribute("contactList", contactList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contacts.jsp");
		dispatcher.forward(request, response);
	}
	
	//OPEN CREATECONTACTPAGE.JSP
	private void showCreateContactPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("showCreateContactPage");
		RequestDispatcher dispatcher = request.getRequestDispatcher("create_contact.jsp");
		dispatcher.forward(request, response);
	}
	
	//OPEN MYCONTACT.JSP
	private void showMyContactPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("showMyContactPage");
		RequestDispatcher dispatcher = request.getRequestDispatcher("my_contact.jsp");
		dispatcher.forward(request, response);
	}
}




















