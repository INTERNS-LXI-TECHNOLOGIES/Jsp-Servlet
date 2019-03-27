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
		System.out.println(name);
		if(name!=null) {
		if(name.equals("true")) {
			req.setAttribute("lang","ml");
			req.setAttribute("cont","IN");
		}
		else {
			req.setAttribute("lang","en");
			req.setAttribute("cont","US");
		}
		
		
		
		}
		RequestDispatcher reqD = req.getRequestDispatcher("contacts");
		reqD.forward(req,res);
		
	}
	
	/*public ResourceBundle lang(boolean a) {
		
		if(a){
			lang = "ml";
			cont = "IN";
		}
		else{
			lang = "en";
			cont = "US";
		}
		System.out.println("haiii");
		Locale l = new Locale(lang,cont);
		ResourceBundle r = ResourceBundle.getBundle("lang",l);
		return r;
	}*/
}
