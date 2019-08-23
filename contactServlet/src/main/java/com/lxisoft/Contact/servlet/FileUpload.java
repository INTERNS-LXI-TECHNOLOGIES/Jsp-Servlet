package com.lxisoft.Contact.servlet;

import java.io.*;
import java.util.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.Servlet;
import javax.swing.text.View;

import com.lxisoft.Contact.model.ContactModel;
import com.lxisoft.Contact.repositoryImpl.RepositoryImpl;


@WebServlet("/csvfile")
public class FileUpload extends HttpServlet implements Servlet {

	ArrayList<ContactModel> contacts = new ArrayList<ContactModel>();

	RepositoryImpl ri = new RepositoryImpl();

	
	public void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		if(request.getParameter("csv")==null)
		{
			response.sendRedirect("View.jsp");
			return;
		}
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		FileInputStream in =null;
		File file=new File(request.getParameter("csv"));
		in =new FileInputStream(file);
		out.println("FullPathname"+" "+ file.getAbsolutePath());
		try {
			String data;

			File f=new File(file.getAbsolutePath());
			FileReader fR = new FileReader(f);
			BufferedReader bR = new BufferedReader(fR);
			while ((data = bR.readLine()) != null) {
				String[] split = data.split(",");
				ContactModel cml = new ContactModel();
				cml.setFirstName(split[0]);
				cml.setLastName(split[1]);
				cml.setPhone(split[2]);
				cml.setMobNumber(split[3]);
				cml.setEmail(split[4]);
				ri.addContact(cml);
				out.println("<h1>" + "Upload completd.." + "</h1>");
				out.println("<a href=" + "View.jsp" + ">back to jsp</a>");
			}
		}

		catch (Exception e) {

		}
	}

	private Object value(String fileitem2) {
		// TODO Auto-generated method stub
		return null;
	}

}
