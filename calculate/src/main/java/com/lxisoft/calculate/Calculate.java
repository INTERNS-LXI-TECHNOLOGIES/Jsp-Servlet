package com.lxisoft.calculate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/calculate")
public class Calculate extends HttpServlet {
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		String a = req.getParameter("action");
		if(a.equals("add")) {
			RequestDispatcher reqD = req.getRequestDispatcher("add");
			reqD.forward(req,res);
		}
		else if(a.equals("sub")) {
			RequestDispatcher reqD = req.getRequestDispatcher("sub");
			reqD.forward(req,res);
		}
		else if(a.equals("div")) {
			RequestDispatcher reqD = req.getRequestDispatcher("div");
			reqD.forward(req,res);
		}
		else if(a.equals("mul")) {
			RequestDispatcher reqD = req.getRequestDispatcher("mul");
			reqD.forward(req,res);
		}
	}
}
