package com.lxisoft.Contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.lxisoft.Contact.repositoryImpl.RepositoryImpl;
import com.lxisoft.Contact.model.*;


@WebServlet("/remove")
public class Remove extends HttpServlet {
	
	RepositoryImpl ri = new RepositoryImpl();
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		try {
int id=Integer.parseInt(req.getParameter("Id"));
ri.deleteContact(id);
PrintWriter out = res.getWriter();
	out.println("<h1>" + "deleted" + "</h1>");
	out.println("<a href="+"View.jsp"+">back to jsp</a>");
}
catch(Exception e) {
}
}
}

