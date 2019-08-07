package com.lxisoft.contact;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*; 
import java.util.*; 
public class ContactServlet extends HttpServlet{  
public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{ 
try{
res.setContentType("text/html");//setting the content type  
PrintWriter out=res.getWriter();//get the stream to write the data  
  Contact contact=new Contact();
	contact.setName(req.getParameter("name"));
	contact.setNum(req.getParameter("num"));
	ContactRepository contactR=new ContactRepository();
	contactR.createContact(contact);
	out.println("<a href="+"index.jsp"+">back to jsp</a>");
out.close();//closing the stream  
}
catch(Exception e)
{
	e.printStackTrace();
}
}
public void doGet(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{ 
try{
res.setContentType("text/html");//setting the content type  
PrintWriter out=res.getWriter();//get the stream to write the data 
ArrayList<Contact> contacts=new ArrayList<Contact>();
	ContactRepository contactR=new ContactRepository();
	// out.println(contactR.readContact());
	contacts=contactR.readContact();
	out.println("<html><body><table>");
	out.println("<tr><th>Contact Name   </th><th>Contact Number</th></tr>");

	for(int i=0;i<contacts.size();i++)
	{
		out.println("<tr><td>");
		out.println(contacts.get(i).getName()); 
		out.println(" </td><td>");
		out.println(contacts.get(i).getNum());
		out.println("</td></tr>");

	
	}

	
	out.println("</table></body></html>");
	out.println("<a href="+"index.jsp"+">back to jsp</a>");
out.close();
} 
 catch(Exception e)
{
	e.printStackTrace();
}
}
}


