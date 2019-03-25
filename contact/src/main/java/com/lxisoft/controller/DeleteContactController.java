package com.lxisoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lxisoft.repo.ContactRepo;
@WebServlet("/deletecontact")
public class DeleteContactController extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String id = req.getParameter("id");
		HttpSession ses = req.getSession();
		String username = (String) ses.getAttribute("username");
		ContactRepo contactRepo = new ContactRepo();
		try {
			contactRepo.deleteContact(id,username);
			res.sendRedirect("contacts");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
