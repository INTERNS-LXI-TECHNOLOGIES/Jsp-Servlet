package com.lxisoft.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogOutController extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		HttpSession ses = req.getSession();
		
		ses.invalidate();
		res.sendRedirect("/contact");
	}
}
