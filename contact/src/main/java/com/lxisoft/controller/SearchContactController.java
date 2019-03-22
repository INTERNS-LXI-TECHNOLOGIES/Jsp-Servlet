package com.lxisoft.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lxisoft.repo.ContactRepo;

@WebServlet("/search")
public class SearchContactController extends HttpServlet {

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		ContactRepo contactRepo = new ContactRepo();
		HttpSession ses = req.getSession();
		String username =(String) ses.getAttribute("username");
		String search = (String)req.getParameter("search");
	
		try {
			req.setAttribute("contacts",contactRepo.getSearchContact(username,search));
			res.getWriter().print(search);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		RequestDispatcher reqD = req.getRequestDispatcher("/Contact.jsp");
		reqD.forward(req,res);
	}
}
