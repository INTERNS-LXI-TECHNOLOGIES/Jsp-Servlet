package com.lxisoft.contact;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*; 
import java.util.*; 
public class ContactServletDelete extends HttpServlet{  
public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{ 
try{
res.setContentType("text/html");//setting the content type  
PrintWriter out=res.getWriter();//get the stream to write the data  
  ContactRepository contactR=new ContactRepository();
	contactR.deleteContact(req.getParameter("name"));
	out.println("<a href="+"index.jsp"+">back to jsp</a>");
out.close();//closing the stream  
}
catch(Exception e)
{
	e.printStackTrace();
}
}

}  