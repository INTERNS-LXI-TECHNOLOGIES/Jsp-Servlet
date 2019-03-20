package com.lxisoft.calculate;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/div")
public class Div extends HttpServlet {

public void service(HttpServletRequest req,HttpServletResponse res) throws IOException, ServletException {
		
		int i = Integer.parseInt(req.getParameter("no1"));
		int j = Integer.parseInt(req.getParameter("no2"));
		int result = i/j;
		req.setAttribute("result",result);
		RequestDispatcher reqD = req.getRequestDispatcher("/Result.jsp");
		reqD.forward(req,res);
	}
}
