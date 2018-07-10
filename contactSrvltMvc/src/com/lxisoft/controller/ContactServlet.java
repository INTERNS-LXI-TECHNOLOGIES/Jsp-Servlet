package com.lxisoft.controller;
import com.lxisoft.model.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;

public class ContactServlet extends HttpServlet{
	

	@Override
public void doPost(HttpServletRequest request,HttpServletResponse response){
	Connection connection = null;
		Statement stmt = null;
	
	String name=(String)request.getSession().getAttribute("a");
	//int id=generateId();
	String phone=(String)request.getSession().getAttribute("b");
	String place=(String)request.getSession().getAttribute("c");
	String emailId=(String)request.getSession().getAttribute("d");
	System.out.println("/////////**************"+name);
	System.out.println("/////////**************"+phone);
	System.out.println("/////////**************"+place);
	System.out.println("/////////**************"+emailId);
	
	
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/contact","root","root");
			stmt=connection.createStatement();
			String sql= "INSERT INTO contable(name,phoneNumber,place,emailID) "+"VALUES ('"+name+"','"+phone+"','"+place+"','"+emailId+"')";
			int i=stmt.executeUpdate(sql);
			if(i>0)                
			System.out.println("Inserted Successfully");              
			else                
			System.out.println("Insert Unsuccessful");    
			
			
			connection.close();
			response.sendRedirect("Contact.jsp?result=success");
		}
		catch(Exception e){
			
			System.out.println(e);
			try{
			response.sendRedirect("Contact.jsp?result=faild");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
		

	
	}
	
		
	public void doGet(HttpServletRequest request,HttpServletResponse response){
	Connection conn = null;
		Statement stmt = null;
		
	try{
		
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");

		stmt = conn.createStatement();
		String sql = "select * from contable";
		//System.out.println(""+sql);
		ResultSet rs = null;	
		rs = stmt.executeQuery(sql);
//System.out.println("rs/get"+rs);
		ArrayList<Contact> contacts=new ArrayList<Contact>();
        while (rs.next()) {
			Contact contact=new Contact(rs);
			/*contact.setName(rs.getString("name"));
			contact.setName(rs.getString("phoneNumber"));
			contact.setName(rs.getString("place"));
			contact.setName(rs.getString("emailId"));*/
			
			contacts.add(contact);
			request.getSession().setAttribute("Contact", contacts);
			
		
		}
		
		
		
		conn.close();
			
			response.sendRedirect("AllContact.jsp");
		
			
		}
	
	
	
		catch(Exception e){
			e.printStackTrace();
			System.out.println(e);
			try{
			response.sendRedirect("AllContact.jsp?result=faild");
			}
			catch(IOException x){
				x.printStackTrace();
			}
		}
	
	
	}
	
		
}