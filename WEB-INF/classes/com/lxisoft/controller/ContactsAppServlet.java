package com.lxisoft.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;


public class ContactsAppServlet extends HttpServlet
    {
	public ContactsAppServlet(){
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
		String name  = request.getParameter("Name");
        System.out.println("name"+name);
        String place = request.getParameter("Place");
        String phn_no = request.getParameter("Phn_no");
        String email = request.getParameter("Email");
      try
        {
	       System.out.println("database first");
	       Class.forName("com.mysql.jdbc.Driver");
	       Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
	
	       PreparedStatement ps = con.prepareStatement("insert into contacts(name,place,Phn_no,Email) values(?,?,?,?)");
	       ps.setString(1,name);
	       ps.setString(2,place);
	       System.out.println("database");
	       ps.setString(3,phn_no);
	       ps.setString(4,email);
	       ps.executeUpdate();
	       con.close();
        }catch(Exception ex)
          {
	         System.out.println(ex);
          }

	}
	
	
    public void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException,ServletException
	{
	
	try{
		Class.forName("com.mysql.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
        PreparedStatement stmt = con.prepareStatement("select * from contacts");
        ResultSet rs = stmt.executeQuery("select name,place,phn_no,email from contacts");

		PrintWriter out = response.getWriter();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	 }

}