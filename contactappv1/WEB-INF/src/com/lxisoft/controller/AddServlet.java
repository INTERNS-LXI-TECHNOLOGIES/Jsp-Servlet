package com.lxisoft.controller;
import java.io.*;  
import java.sql.*;
import java.util.ArrayList;  
import javax.servlet.ServletException;  
import javax.servlet.RequestDispatcher;
import javax.servlet.http.*; 
import com.lxisoft.model.*;

 

public class AddServlet extends HttpServlet{
ArrayList<Contact> contactList;
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);

}	
public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
{
	
response.setContentType("text/html"); 
PrintWriter out = response.getWriter();
  
System.out.println("@@@@@@@@@@@@@@@addContact");
String name=request.getParameter("userName");  
String phNumber=request.getParameter("phNumber");  
String email=request.getParameter("userEmail");  
Contact contact=new Contact(name,phNumber);
contact.setEmail(email);

contactList=new ArrayList<Contact>();
if(contactList.add(contact)){
	System.out.println("Contact added");
	System.out.println(contactList);
	response.sendRedirect("/contactappv1/home.html");
}
else{
	System.out.println("Try again");
}
out.close();
}


}