package com.lxisoft.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.sql.*;
import java.sql.*;
import java.util.ArrayList;

public class ContactServlet extends HttpServlet{
	

	@Override
public void doGet(HttpServletRequest request,HttpServletResponse response){
	Connection connection = null;
		Statement stmt = null;
	System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>put working");
	String name=(String)request.getAttribute("a");
	//int id=generateId();
	String phone=(String)request.getAttribute("b");
	String place=(String)request.getAttribute("c");
	String emailId=(String)request.getAttribute("d");
	System.out.println();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/Contact","root","root");
			stmt=connection.createStatement();
			String sql= "INSERT INTO contable(name,phoneNumber,place,emailID) "+"VALUES ('"+name+"','"+phone+"','"+place+"','"+emailId+"')";
				System.out.println("<<<<<<<<<<<<<<"+sql);

			System.out.println("comment ))))))))))))"+stmt.executeQuery(sql));
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
	public int generateId(){
		
		return (int)((Math.random()*7)+(Math.random()*9)-(Math.random()*3)%(Math.random()*5)+((Math.random()*9)*(Math.random()*9)));
		
	}
		
		
	
		
}