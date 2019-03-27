package com.lxisoft.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lxisoft.model.ContactDetails;
import com.lxisoft.repo.ContactRepo;

@WebServlet("/contacts")
public class ContactDetailsController extends HttpServlet {
	
	int count = 0;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses = req.getSession();
		String username = (String) ses.getAttribute("username");
		if(username!=null) {
		ContactRepo contactRepo = new ContactRepo();
		List<ContactDetails> contacts = null;
		List<ContactDetails> contactsp = new ArrayList<ContactDetails>();
		try {
			contacts = contactRepo.getContact(username);
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		} catch (SQLException e1) {
			
			e1.printStackTrace();
		}
		if(req.getParameter("prev")!= null) {
			if(count!=0) {
				count = count - 5;
			}
		}
		if(req.getParameter("next")!= null) {
			if(count<contacts.size()-5) {
				count = count + 5;
			}
		}
		for(int i = count;i<(count+5);i++) {
			if(i<contacts.size()) {
			contactsp.add(contacts.get(i));
			}
		}
		req.setAttribute("contacts",contactsp);
		
		RequestDispatcher reqD = req.getRequestDispatcher("/Contact.jsp");
		reqD.forward(req,res);
		}
		else {
			res.sendRedirect("index.jsp");
		}
	}
	
}
