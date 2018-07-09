package com.lxisoft.controllerServlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import com.lxisoft.controller.ContactController;
import java.util.logging.Logger;
import com.lxisoft.model.Contact;

public class CreateContactObjectServlet extends HttpServlet
{
	private static final Logger LOGGER=Logger.getLogger(CreateContactObjectServlet.class.getName());
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		Contact contact=new Contact();
		contact.setName("");
		contact.setPlace("");
		contact.setPhoneNumber("");
		contact.setEmail("");
		HttpSession session=request.getSession();
		session.setAttribute("contactSession",contact);
		response.sendRedirect("addContact.jsp");
	}
}