package com.lxisoft.controller;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/lang")
public class Lang extends HttpServlet{
	String lang = "ml";
	String cont = "IN";

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		String name = req.getParameter("l");
		HttpSession ses = req.getSession();
		if(name!=null) {
		if(name.equals("true")) {
			ses.setAttribute("lang","ml");
			ses.setAttribute("cont","IN");
		}
		else {
			ses.setAttribute("lang","en");
			ses.setAttribute("cont","US");
		}
		}
		RequestDispatcher reqD = req.getRequestDispatcher("contacts");
		reqD.forward(req,res);
		
	}
	
}
