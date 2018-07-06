package com.lxisoft.controller;
import java.io.*;
import java.util.*;
import com.lxisoft.model.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class ContactController extends HttpServlet{
	
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response){
	System.out.println("post working");
	String name=request.getParameter("name");
	String phone=request.getParameter("phone");
	System.out.println("dopost/name"+name);
	System.out.println("dopost/phone"+phone);
	Connection conn = null;
	Statement stmt = null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactssvlt", "root", "root");
			stmt = conn.createStatement();
			String sql = "insert into contactss(name,phone) values('"+name+"','"+phone+"')";
			int i=stmt.executeUpdate(sql);
			if(i>0)                
			System.out.println("Inserted Successfully");              
			else                
			System.out.println("Insert Unsuccessful");        
			conn.close();
			response.sendRedirect("Contact.jsp?result=success");
		}
		catch(Exception e){
			
			System.out.println(e);
			try{
			response.sendRedirect("Contact.jsp?result=failed");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
}


@Override
public void doGet(HttpServletRequest request,HttpServletResponse response){
	System.out.println("get is working");
	//String getName=request.getParameter("name");
	Connection conn = null;
	Statement stmt = null;
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactssvlt", "root", "root");

		stmt = conn.createStatement();
		String sql = "select * from contactss";
		//System.out.println(""+sql);
		ResultSet rs = null;	
		rs = stmt.executeQuery(sql);
//System.out.println("rs/get"+rs);
		ArrayList<Contact> contacts=new ArrayList<Contact>();
        while (rs.next()) {
			System.out.println("rs.next");
			Contact contact =new Contact(rs);
			contact.setName(rs.getString("name"));
			contact.setPhoneNumber(rs.getString("phone"));
       
			
			//RequestDispatcher view = request.getRequestDispatcher("Contact.jsp");
			//System.out.println("getName"+getName);
			System.out.println("contact.getName"+contact.getName());
			System.out.println("contact.getPhone"+contact.getPhoneNumber());
			contacts.add(contact);
			System.out.println("contacts size"+contacts.size());
			request.getSession().setAttribute("Contact", contacts);
			response.sendRedirect("Details.jsp");
			System.out.println("name display============");
						
							
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


	@Override
	public void doDelete(HttpServletRequest request,HttpServletResponse response){
		
	String name=request.getParameter("name");
	//out.println(""+name);
	
	
	try{
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactssvlt", "root", "root");

		stmt = conn.createStatement();
		String sql = "delete from contactss where name='"+name+"'";
		//out.println(" "+sql);
		//ResultSet rs = null;
		System.out.println("Do you want to delete this entry");
		int rs=stmt.executeUpdate(sql);
	}
		catch(Exception e){
		
		System.out.println(e);
	}
		
}


		
	
}