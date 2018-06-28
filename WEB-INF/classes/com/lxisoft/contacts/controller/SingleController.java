package com.lxisoft.contacts.controller;

//cd apache-tomcat-7.0.72\webapps\contacts\WEB-INF\src
//javac -classpath D:\apache-tomcat-7.0.72\lib\servlet-api.jar;. com\lxisoft\contacts\controller\SingleController.java
//http://localhost:8080/contacts/index.jsp
//changing 'classes' to 'src' -> problem (war)

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

/**
* This program gives a hands-on experience on Jsp-Servlet-MySql-FileUtils-DatabaseUtils
*
* @author  Vyshnav Ramesh
* @version 1.0
* @since   2018-06-28 
*/
@WebServlet("/")
public class SingleController extends HttpServlet{
	
	private ContactService contactService;
	
	//OVERRIDE INIT METHOD OF GENERICSERVLET
	@Override
	public void init() {
		System.out.println("init");
		String url=getServletContext().getInitParameter("url");
		String username=getServletContext().getInitParameter("username");
		String password=getServletContext().getInitParameter("password");
		DatabaseUtils dbUtils = DatabaseUtils.getInstance();
		dbUtils.configure(url,username,password);
	}


	//POST METHOD
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("doPost");
		doGet(request, response);
	}

	//GET METHOD
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("doGet");
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
		System.out.println("signup_SingleController");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		UserService userService = new UserService();
		boolean userCeated = userService.create(user);
		if(userCeated){
			System.out.println("signup successful");
			user = userService.read(username, password);
			request.getSession().setAttribute("userId", user.getUserId());						// 2nd parameter: type Object (mayb auto parsed)
			showCreateContactPage(request, response);
		}else{
			System.out.println("signup failed");
		}
			
	}
	
	//LOGIN	
	private void login(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("login_SingleController");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserService userService = new UserService();
		User user = userService.read(username, password);
		if(user != null){												
			System.out.println("login success");
			request.getSession().setAttribute("userId", user.getUserId());	// 2nd parameter: type Object (mayb auto parsed)
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit_contact.jsp");
			dispatcher.forward(request, response);
		}else{
			System.out.println("login failed");
		}	
	}
	
	//LOGOUT	
	private void logout(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("logout_SingleController");
		HttpSession session = request.getSession();
		//session.removeAttribute("username");
		//session.removeAttribute("user_id");
		//session.removeAttribute("profile");
		session.invalidate();
		RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
		dispatcher.forward(request,response);
	}
	
	//CREATE CONTACT
	private void createContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("create_SingleController");
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
		System.out.println("showMyContactPage_SingleController");
		HttpSession session = request.getSession();
		int userId = (int) request.getSession().getAttribute("userId");	
		ContactService contactService = new ContactService();
		Contact contact = contactService.read(userId);
		return contact;
	}
	
	//READ ALL CONTACTS
	 private List<Contact> readAllContacts() throws SQLException{
		System.out.println("readAll_SingleController");
		ContactService contactService = new ContactService();
		List<Contact> contactList = contactService.readAll();
		return contactList;
	}	
		
	//EDIT CONTACT	
	private void editContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("editContact_SingleController");
		Contact contact = readContact(request, response);
		request.setAttribute("contact",contact);
		RequestDispatcher dispatcher = request.getRequestDispatcher("edit_contact.jsp");
		dispatcher.forward(request,response);
	}	
		
	//UPDATE CONTACT
	private void updateContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("updateContact_SingleController");
		int userId = (int) request.getSession().getAttribute("userId");	
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		Contact updatedContact = new Contact(userId, name, phone);
		ContactService contactService = new ContactService();
		boolean contactUpdated = contactService.update(updatedContact);	
		if(contactUpdated) {
			System.out.println("Contact updated..");
			request.setAttribute("contact",updatedContact);
			showMyContactPage(request, response);
		}else {
	    	System.out.println("Contact not updated");
		}
	
	}
	
	//DELETE CONTACT
	private void deleteContact(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("deleteContact_SingleController");
		int userId = (int) request.getSession().getAttribute("userId");	
		ContactService contactService = new ContactService();
		boolean contactdeleted = contactService.delete(userId);	
		if(contactdeleted) {
			System.out.println("Contact deleted..");
			showCreateContactPage(request, response);	
		}else {
	    	System.out.println("Contact not updated");
		}
	}
	
	//OPEN CONTACTS.JSP
	private void showContactsPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("showContactsPage_SingleController");
		List<Contact> contactList = readAllContacts();
		request.setAttribute("contactList", contactList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contacts.jsp");
		dispatcher.forward(request, response);
	}
	
	//OPEN CREATECONTACTPAGE.JSP
	private void showCreateContactPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("showCreateContactPage_SingleController");
		RequestDispatcher dispatcher = request.getRequestDispatcher("create_contact.jsp");
		dispatcher.forward(request, response);
	}
	
	//OPEN MYCONTACT.JSP
	private void showMyContactPage(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException{
		System.out.println("showMyContactPage_SingleController");
		RequestDispatcher dispatcher = request.getRequestDispatcher("my_contact.jsp");
		dispatcher.forward(request, response);
	}
}




















