package com.lxisoft.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import com.lxisoft.model.*;
import java.util.*;


public class ContactsAppServlet extends HttpServlet
    {
		
	Database database;
	
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
	       //Class.forName("com.mysql.jdbc.Driver");
		   database = new Database("jdbc/db");
	      // Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
	      Connection con = database.getConnection();
	
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
	    List<Contact> contacts = new ArrayList<Contact>();
		PrintWriter out = response.getWriter();
	try{
		//Class.forName("com.mysql.jdbc.Driver");
		 database = new Database("jdbc/db");
        //Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
        Connection con = database.getConnection();
		Statement stmt = con.createStatement();
        
        ResultSet rs = stmt.executeQuery("select name,place,phn_no,email from contacts");
		while(rs.next())
		{
			contacts.add(new Contact(rs.getString("name"),rs.getString("place"),rs.getString("phn_no"),rs.getString("email")));
			/*contacts.get(contacts.size()-1).setFirstName(rs.getString("name"));
			contacts.get(contacts.size()-1).setPlace(rs.getString("place"));
			contacts.get(contacts.size()-1).setPhone_Number(rs.getString("phn_no"));
			contacts.get(contacts.size()-1).setEmail_Id(rs.getString("email"));*/
		}
		HttpSession session = request.getSession();
		session.setAttribute("contacts",contacts);
		response.sendRedirect("loginPage.jsp");

	}catch(Exception e)
	{
		e.printStackTrace();
	}
	 }

}