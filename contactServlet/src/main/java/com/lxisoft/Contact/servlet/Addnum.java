package com.lxisoft.Contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxisoft.Contact.model.ContactModel;
import com.lxisoft.Contact.repositoryImpl.RepositoryImpl;


@WebServlet("/addnumber")
public class Addnum extends HttpServlet {
	ArrayList<ContactModel> contacts = new ArrayList <ContactModel>();
	ArrayList<String> phno = new ArrayList<String>();
	RepositoryImpl ri = new RepositoryImpl();
	RepositoryImpl si = new RepositoryImpl();
	int count = 0;
	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException 
	{
		try {
			String namer=req.getParameter("nam");
			String numbr=req.getParameter("num");
			si.searchContact(namer,numbr);
    		PrintWriter out = res.getWriter();
      		out.println("<a href="+"Read.jsp"+">back to jsp</a>");
		}
		catch(Exception e) {
		}
		}
      	}