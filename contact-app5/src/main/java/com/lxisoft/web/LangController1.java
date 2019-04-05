package com.lxisoft.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/lang1")
public class LangController1 extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	
	String lang="eng";
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String ln=request.getParameter("l");
		
		if(ln!=null) {
			if(ln.equals("mal")) {
				
				request.setAttribute("lang", "mal");
			}
			else if(ln.equals("eng")) {
				
				request.setAttribute("lang", "eng");
			}
			else if(ln.equals("hin")) {
				
				request.setAttribute("lang", "hin");
			}
		}
		
	RequestDispatcher rd=request.getRequestDispatcher("AddContact.jsp");
	rd.forward(request, response);
	}
}