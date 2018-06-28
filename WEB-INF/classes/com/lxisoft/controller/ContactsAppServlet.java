package com.lxisoft.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class ContactsAppServlet extends HttpServlet
{
	public ContactsAppServlet()
	{
		
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		
	}
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
    {
     PrintWriter out = res.getWriter();
	 
	 out.println("<html>"+"<body>"+"<h1 align = center>Contacts</h1>"+"</html>"+"</body>");
	}

}