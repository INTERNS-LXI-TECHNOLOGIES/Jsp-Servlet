package com.lxisoft.web;

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
public class LangController extends HttpServlet{
	String lang = "ml";
	String cont = "IN";

	public void service(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("l");
		System.out.println(name);
		if(name!=null) {
		if(name.equals("true")) {
			request.setAttribute("lang","ml");
			request.setAttribute("cont","IN");
		}
		else {
			request.setAttribute("lang","en");
			request.setAttribute("cont","US");
		}
		
		}
		RequestDispatcher rd = request.getRequestDispatcher("AddContact.jsp");
		rd.forward(request,response);
		
	}
}



