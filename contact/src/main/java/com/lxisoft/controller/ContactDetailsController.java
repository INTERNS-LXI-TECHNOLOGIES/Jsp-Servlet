package com.lxisoft.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/contacts")
public class ContactDetailsController extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		String username = req.getParameter("username");
		RequestDispatcher reqD = req.getRequestDispatcher("/Contact.jsp");
		reqD.forward(req,res);
	}
	
}
