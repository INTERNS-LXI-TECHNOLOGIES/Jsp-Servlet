package com.lxisoft.calculate;

import java.io.IOException;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/sub")
public class Sub extends HttpServlet {
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		
		int i = Integer.parseInt(req.getParameter("no1"));
		int j = Integer.parseInt(req.getParameter("no2"));
		int result = i-j;
		req.setAttribute("result",result);
		RequestDispatcher reqD = req.getRequestDispatcher("/Result.jsp");
		reqD.forward(req,res);
	}
}
