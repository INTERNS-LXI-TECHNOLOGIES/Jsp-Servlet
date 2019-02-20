package com.lxisoft.controller;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.util.ArrayList;
import com.lxisoft.model.Contact;


public class AddContact extends HttpServlet{
	ArrayList<Contact> list;
	File file=new File("D:/Project/tomcat/webapps/contact-app/data/ContactList.txt");
	FileWriter fw=null;
	BufferedWriter bw=null;
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
	try{
			PrintWriter out=response.getWriter();
			list=new ArrayList<Contact>();
			String name=request.getParameter("name");
			String phno=request.getParameter("phno");
			Contact contact=new Contact(name,phno);
			list.add(contact);
			fw=new FileWriter(file,true);
			bw=new BufferedWriter(fw);
			bw.write(contact.getName()+";");
			bw.write(contact.getPhno()+"\n");
			bw.close();
			fw.close();
			response.sendRedirect("saved.jsp");
			
		}
		catch(Exception e){

			e.printStackTrace();
		}
	}
}