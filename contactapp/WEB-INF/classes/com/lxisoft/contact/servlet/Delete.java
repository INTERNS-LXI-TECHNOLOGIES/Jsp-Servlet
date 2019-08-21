package com.lxisoft.contact.servlet;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.servlet.annotation.WebServlet;
import com.lxisoft.contact.model.*;
import com.lxisoft.contact.repo.*;
import java.sql.*;
import java.io.*;
@WebServlet("/delete")
public class Delete extends HttpServlet
{
	
	public void doPost(HttpServletRequest request,HttpServletResponse res)throws ServletException
	{
		try{
			RepositoryImpl re=new RepositoryImpl();
		String data=request.getParameter("name");
re.delete(data);
PrintWriter out=res.getWriter();
			out.println("<h1>"+"Deleted"+"</h1>");
			out.println("<a href="+"delete.jsp"+">back to jsp</a>");
		}
		catch(Exception e){//System.out.println(e);
	e.printStackTrace();}
		
	}
	
	
}