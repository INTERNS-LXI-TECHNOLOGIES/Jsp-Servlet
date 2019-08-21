package com.lxisoft.controller;
import com.lxisoft.contact.*;
import javax.servlet.http.*;
import javax.servlet.*;
import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
 import javax.servlet.Servlet;

public class UploadServlet extends HttpServlet
{
	private final String UPLOAD_DIRECTORY = "C:/uploads";
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws ServletException,IndexOutOfBoundsException
	{
		if(ServletFileUpload.isMultipartContent(req))
		{
			try
            {
            	res.setContentType("text/html");
				PrintWriter pw=res.getWriter();
            	//InputStream csvfile = null;	
            	InputStream is = null;
  				FileItemFactory factory = new DiskFileItemFactory();
  				ServletFileUpload upload = new ServletFileUpload(factory);
  				List items = upload.parseRequest(req);




  			}
		
	/*	try
		{
			

			FileWriter fw=new FileWriter(file,true);
			FileReader fr=new FileReader(file);
			BufferedReader br=new BufferedReader(fr);
			int k=0;	
			String data;	
			while((data=br.readLine())!=null)
				{
					Contact contact=new Contact();
					String item[]=data.split(",");
					contact.setName(item[k]);
					contact.setNumber(item[k+1]);
					RepoImpl repoImpl=new RepoImpl();
					repoImpl.createContact(contact);
					//contactList.add(contact);
				}
			br.close(); 

			// RepoImpl repoImpl=new RepoImpl();
			// //int status=
			// repoImpl.createContact(contact);
		}*/
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	}
}