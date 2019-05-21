package com.lxisoft.controller;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.repo.ContactRepo;

@WebServlet("/login")
public class LoginController extends HttpServlet{


	public void service(HttpServletRequest req,HttpServletResponse res) {
		String uname= req.getParameter("username");
		String pass= req.getParameter("password");
		ContactRepo repo = new ContactRepo();
		boolean a= repo.checkLogin(uname,pass);
		try {
			if(a) {
				
					res.sendRedirect("/contact/Contact.jsp");
				
			}
			else {
				res.sendRedirect("/contact/index.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}
	}
}
