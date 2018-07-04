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
			response.sendRedirect("Contact.jsp?result=done");
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
	try{
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contactssvlt", "root", "root");

		stmt = conn.createStatement();
		String sql = "select * from contactss";
		ResultSet rs = null;	
		rs = stmt.executeQuery(sql);

        while (rs.next()) {
			//   Contact contact = new Contact(rs.getString("name"),rs.getString("phone"));
			//response.sendRedirect("Contact.jsp?result=done");
			String name=request.getParameter("name");
			request.setAttribute("name", name);
			System.out.println("dfsvgxcvxc"+name);
			String phone=request.getParameter("phone");
			request.setAttribute("phone", phone);
			System.out.println("dfsvgxcvxc"+phone);
			RequestDispatcher rd=request.getRequestDispatcher("/Contact.jsp");
			rd.forward(request, response);
			/*Contact contact=new Contact(rs);
			contact.setName(rs.getString("name"));
			contact.setPhoneNumber(rs.getString("phone"));
        
		
			request.setAttribute("contact", contact);
			RequestDispatcher view = request.getRequestDispatcher("Contact.jsp");
			view.forward(request, response);*/
		}
		//out.println("*"+contact.getString(getName()));
		conn.close();
    } catch (Exception e) {
        System.out.println(e);
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