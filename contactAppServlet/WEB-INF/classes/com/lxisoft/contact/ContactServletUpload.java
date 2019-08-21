package com.lxisoft.contact;
import javax.servlet.http.*;  
import javax.servlet.*;  
import java.io.*; 
import java.util.*; 
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
public class ContactServletUpload extends HttpServlet{  
public void doPost(HttpServletRequest req,HttpServletResponse res)  throws ServletException,IOException  
{ 
try{
res.setContentType("text/html");//setting the content type  
PrintWriter out=res.getWriter();//get the stream to write the data 
 Part inputFile = req.getPart("fname"); 
ContactRepository contactR=new ContactRepository();
}
catch(Exception e)
{
	e.printStackTrace();
}

}
}