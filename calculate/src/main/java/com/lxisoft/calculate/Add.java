package com.lxisoft.calculate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
@WebServlet("/add")
public class Add extends HttpServlet {
	
	public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		int i = Integer.parseInt(req.getParameter("no1"));
		int j = Integer.parseInt(req.getParameter("no2"));
		int result = i+j;
		//HttpSession ses = req.getSession();
		req.setAttribute("result",result);
		RequestDispatcher reqD = req.getRequestDispatcher("/Result.jsp");
		reqD.forward(req,res);
	}
}
