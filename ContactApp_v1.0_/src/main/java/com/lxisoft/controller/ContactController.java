package com.lxisoft.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.model.*;
//import com.lxisoft.view.*;
import com.lxisoft.repo.ContactRepo;

@WebServlet("/addcontact")
public class ContactController extends HttpServlet{



public void service(HttpServletRequest req,HttpServletResponse res) {		
	String name = req.getParameter("name");
	String num = req.getParameter("number");
	String mail = req.getParameter("email");
	Contact contact = new Contact();
	ContactRepo repo = new ContactRepo();
	boolean a=repo.contactDis(name, num, mail);
	contact.setName(name);
	contact.setMobileNo(num);
	contact.setEmail(mail);
	try {
	if(a) {
		
			res.sendRedirect("/contact/AddContact");
	}
		
	
	else {
		res.sendRedirect("/contact/Index.jsp");
	}
	}catch (IOException e) {
	// TODO Auto-generated catch block
		e.printStackTrace();}




 
}
}