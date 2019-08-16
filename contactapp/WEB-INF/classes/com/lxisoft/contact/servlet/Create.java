
package com.lxisoft.contact.servlet;
import java.util.*;
import com.lxisoft.contact.model.*;
import com.lxisoft.contact.repo.*;
import java.sql.*;
import java.io.*;
@WebServlet("/create")
public class Create extends HttpServlet
{
	
	public void service(HttpServletRequest request,HttpServletResponse res)throws Servlet
	{
		try{
		
		Contact contact=new Contact();

contact.setName(request.getParameter("Name"));
contact.setPhoneNumber(request.getParameter("PhoneNumber"));
RepositoryImpl repo=new RepositoryImpl();
repo.create(contact);
PrintWriter out=res.getWriter();
out.println("<h1>"+"Created"+"</h1>");
out.println("<a href="+"create,jsp"+">back to jsp</a>");
		}
		catch(Exception e){//System.out.println(e);
	e.printStackTrace();}
		
	}
	
	
}