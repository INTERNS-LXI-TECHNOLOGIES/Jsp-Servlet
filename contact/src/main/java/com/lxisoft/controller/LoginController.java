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

import com.lxisoft.repo.LoginRepo;

@WebServlet("/login")
public class LoginController extends HttpServlet {
	

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {

		String a = req.getParameter("action");
		LoginRepo loginRepo = new LoginRepo();
		if(a.equals("login")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			HttpSession ses = req.getSession();
			ses.setAttribute("username", username);
			try {
				if(password.equals(loginRepo.getUser(username))) {
					RequestDispatcher reqD = req.getRequestDispatcher("lang");
					reqD.forward(req,res);
					
				}
				else {
					res.sendRedirect("index.jsp");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		else if(a.equals("register")) {
			String username = req.getParameter("username");
			String password = req.getParameter("password");
			try {
				loginRepo.setUser(username,password);
				res.sendRedirect("index.jsp");
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
		}
	}
}
