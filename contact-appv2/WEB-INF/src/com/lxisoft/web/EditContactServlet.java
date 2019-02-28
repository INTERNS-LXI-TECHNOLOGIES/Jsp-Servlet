package com.lxisoft.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.Contact;

public class EditContactServlet extends HttpServlet{

	ContactService service=new ContactService();
	ArrayList<Contact> contactList;
	ArrayList<String> list;
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		PrintWriter out=response.getWriter();
		String name1=request.getParameter("name");
		list=service.searchContact(name1);
		request.setAttribute("list",list);
		RequestDispatcher rd= request.getRequestDispatcher("editpage.jsp");
		rd.forward(request, response);
	}
		public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

			String upName=request.getParameter("name");
			String upPhno=request.getParameter("phno");

			String result=service.editContact(upName,upPhno);
			HttpSession session = request.getSession();
			session.setAttribute("result", result);
	    	RequestDispatcher rd= request.getRequestDispatcher("Editcontact.jsp");
	    	rd.forward(request, response);

		}
}