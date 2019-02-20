package com.lxisoft.controller;
import java.io.*;  
import java.sql.*; 
import javax.servlet.ServletException;  
import javax.servlet.RequestDispatcher;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import javax.servlet.http.*; 
import com.lxisoft.model.*;


 

public class AddServlet extends HttpServlet{
	File contactDetails=new File("D:/lxisoft.app/apache-tomcat-8.5.38/webapps/contactappv1/data/Contacts.txt");

public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request, response);

}	

public void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException 
{
	
response.setContentType("text/html"); 
PrintWriter out = response.getWriter();
  
System.out.println("@@@@@@@@@@@@@@@addContact");
String name=request.getParameter("userName"); 
String phone=request.getParameter("phone"); 
String phNumber=request.getParameter("phNumber");  
String email=request.getParameter("userEmail");  
Contact contact=new Contact(name,phNumber);
contact.setEmail(email);
contact.setUserPhone(phone);
FileWriter fw=null;
BufferedWriter bw=null;

	try{
	fw=new FileWriter(contactDetails,true);
	bw=new BufferedWriter(fw);
	bw.write(name+","+phone+","+phNumber+","+email);
	bw.newLine();
	}catch(IOException e){
			System.out.println("Error");	
		}finally{
			try{
				if (bw != null)
					bw.close();
				if (fw != null)
					fw.close();}
			catch(IOException e){
				e.printStackTrace();}
	}
	System.out.println("Contact added");
	
	
	response.sendRedirect("/contactappv1/home.html");
out.close();
}


}