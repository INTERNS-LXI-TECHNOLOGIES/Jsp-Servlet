package com.lxisoft.Contact.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.jws.WebService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.lxisoft.Contact.model.ContactModel;
import com.lxisoft.Contact.repositoryImpl.RepositoryImpl;

@WebServlet("/create")
public class Create extends HttpServlet {
	ArrayList<ContactModel> contacts = new ArrayList <ContactModel>();
	ArrayList<String> phno = new ArrayList<String>();
	RepositoryImpl ri = new RepositoryImpl();
	RepositoryImpl si = new RepositoryImpl();
	int count = 0;

	public void service(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
		try {
			ContactModel cm = new ContactModel();
    		String username=req.getParameter("username");
			String phone_number=req.getParameter("userphonenumber");
			String mail_id=req.getParameter("usermailid");
			cm.setName(username);
			phno.add(phone_number);
			cm.setPhoneNumber(phno);
			cm.setMailId(mail_id);
			ri.createContact(cm);
    		PrintWriter out = res.getWriter();
      		out.println("<h1>" + "created" + "</h1>");
      		out.println("<a href="+"index.jsp"+">back to jsp</a>");
		}
		catch(Exception e) {
		}
		}
      	}
     