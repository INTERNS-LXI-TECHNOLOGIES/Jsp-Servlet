package com.lxisoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lxisoft.model.ContactDetails;
import com.lxisoft.repo.ContactRepo;

@WebServlet("/editcontact")
public class EditContactController extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) {
		
		ContactRepo contactRepo = new ContactRepo();
		ContactDetails contact = new ContactDetails();
		contact.setName(req.getParameter("name"));
		contact.setEmailid(req.getParameter("emailid"));
		contact.setNumber(req.getParameter("number"));
		contact.setId(req.getParameter("id"));
		
		HttpSession ses = req.getSession();
		String username = (String) ses.getAttribute("username");
		try {
			contactRepo.editContact(contact,username);
			res.sendRedirect("contacts");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}
