package com.lxisoft.contacts.controller;

//cd C:\Program Files\apache-maven-3.5.2\contacts-container security
//http://localhost:8080/contacts-maven/index.jsp

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
* This program gives a hands-on experience on Container Security provided by JEE
*
* @author  Vyshnav Ramesh
* @version 1.3
* @since   2018-07-19 
*/
@WebServlet("/")
public class SingleController extends HttpServlet{
	
	private static final Logger LOGGER = LogManager.getLogger(SingleController.class.getName());
	
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
			showCreateContactPage(request, response);
		}else{
			LOGGER.info("signup failed");
		}
			
	}
	
	//LOGOUT	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("logout");
		HttpSession session = request.getSession();
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request,response);
	}
	
	//CREATE CONTACT
	private void createContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("create");
		String username = request.getRemoteUser();				
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		Contact contact = new Contact(username, name, phone);
		ContactService contactService = new ContactService();
		contactService.create(contact);	
		request.setAttribute("contact",contact);
		showMyContactPage(request, response);
		
	}
	
		
	//READ CONTACT
	private Contact readContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("readContact");
		String username = request.getRemoteUser();
		ContactService contactService = new ContactService();
		Contact contact = contactService.read(username);
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit-contact.jsp");
		dispatcher.forward(request,response);
	}	
		
	//UPDATE CONTACT
	private void updateContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("updateContact");
		String username = request.getRemoteUser();	
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		Contact updatedContact = new Contact(username, name, phone);
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
		String username = request.getRemoteUser();
		ContactService contactService = new ContactService();
		boolean contactdeleted = contactService.delete(username);	
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
		RequestDispatcher dispatcher = request.getRequestDispatcher("create-contact.jsp");
		dispatcher.forward(request, response);
	}
	
	//OPEN MYCONTACT.JSP
	private void showMyContactPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		LOGGER.info("showMyContactPage");
		RequestDispatcher dispatcher = request.getRequestDispatcher("my-contact.jsp");
		dispatcher.forward(request, response);
	}
}




















