package com.lxisoft.controller;

//cd apache-tomcat-7.0.72\webapps\contact_version1\WEB-INF\classes
//javac -classpath D:\apache-tomcat-7.0.72\lib\servlet-api.jar;. com\lxisoft\controller\SingleController.java


import java.io.*;
import com.lxisoft.model.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.lxisoft.service.*;

@WebServlet("/")
public class SingleController extends HttpServlet{

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
				case "/create":
					create(request,response);
					break;
				case "/login":
					login(request,response);
					break;
				case "/signup":
					signup(request,response);
					break;	
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//SIGNUP	
	private void signup(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("signup_SingleController");
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(id, username, password);
		UserService userService = new UserService();
		userService.create(user);
		request.getSession().setAttribute("id", id);						// Check if int (here id) can be given as argument or if only objects are allowed 
		RequestDispatcher dispatcher = request.getRequestDispatcher("create_contact.jsp");
		dispatcher.forward(request, response);	
	}
	
	//LOGIN	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("login_SingleController");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User user = new User(username, password);
		UserService userService = new UserService();
		User userResult = userService.read(user);
		if(userResult != null){												//Ask sir if try-catch can be used instead
			System.out.println("login success");
			request.getSession().setAttribute("id", userResult.getId());		// Check if int (here id) can be given as argument or if only objects are allowed 
			RequestDispatcher dispatcher = request.getRequestDispatcher("edit_contact.jsp");
			dispatcher.forward(request, response);
		}else{
			System.out.println("login failed");
		}	
	}
	
	//CREATE CONTACT
	private void create(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("create_SingleController");
		int id = (int) request.getSession().getAttribute("id");					
		String name = request.getParameter("name");
		int phone = Integer.parseInt(request.getParameter("phone"));
		Contact contact = new Contact(id, name, phone);
		ContactService contactService = new ContactService();
		contactService.create(contact);	
		showContactsPage(request, response);
		
	}
	
	//READ ALL CONTACTS
	private List<Contact> readAll(){
		System.out.println("readAll_SingleController");
		ContactService contactService = new ContactService();
		List<Contact> contactList = contactService.readAll();
		return contactList;
	}
	
	//OPEN CONTACTS.JSP
	private void showContactsPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		System.out.println("showContactsPage_SingleController");
		List<Contact> contactList = readAll();
		request.setAttribute("contactList", contactList);
		RequestDispatcher dispatcher = request.getRequestDispatcher("contacts.jsp");
		dispatcher.forward(request, response);
	}
		

	

		
		
		
		
}





