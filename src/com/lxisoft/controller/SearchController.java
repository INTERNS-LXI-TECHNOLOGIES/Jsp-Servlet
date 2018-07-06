package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class SearchController extends HttpServlet{
	

public void doGet(HttpServletRequest request,HttpServletResponse response){
	System.out.println("get/search is working");
	String getName=request.getParameter("name");
	Connection conn = null;
	Statement stmt = null;
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactssvlt", "root", "root");

		stmt = conn.createStatement();
		String sql = "select name,phone from contactss where name='"+getName+"'";
		//System.out.println(""+sql);
		ResultSet rs = null;	
		rs = stmt.executeQuery(sql);
		//System.out.println("rs/get"+rs);
	
        while (rs.next()) {
			Contact contact =new Contact(rs.getString("name"),rs.getString("phone"));
			//contact.setName(rs.getString("name"));
			//contact.setPhoneNumber(rs.getString("phone"));

		//rs.getString("name"));
		//rs.getString("phone"));
		
			request.getSession().setAttribute("Contact", contact);
			response.sendRedirect("search.jsp");
			System.out.println("name equl============");
			
	
		}
		//out.println("*"+contact.getString(getName()));
		//conn.close();
	}
    catch (Exception e) {
        System.out.println(e);
    }
	finally {
      // Always close the database connection.
      try {
        if (conn != null) conn.close();
      }
      catch (SQLException ignored) { }
   }
	
}

}