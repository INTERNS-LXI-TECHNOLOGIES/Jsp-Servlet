package com.lxisoft.controllerServlet;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.RequestDispatcher;
import com.lxisoft.controller.ContactController;
import java.util.*;
import com.lxisoft.model.*;

public class ViewContactServlet extends HttpServlet
{
	ContactController contactController=new ContactController();
	public void doPost(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		
	}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws IOException,ServletException
	{
		ContactController cont=new ContactController();
		Set<Contact> contacts=cont.viewContact();
		request.setAttribute("cont",contacts);
		RequestDispatcher rd=request.getRequestDispatcher("viewContact.jsp");
		rd.forward(request,response);
	}
}