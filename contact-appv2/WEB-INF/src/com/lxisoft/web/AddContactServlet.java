package com.lxisoft.web;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.annotation.WebServlet;
import com.lxisoft.service.ContactService;
import com.lxisoft.model.Contact;

public class AddContactServlet extends HttpServlet{

	ContactService service=new ContactService();
	ArrayList<Contact> contactList;
	@Override
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		
		String name=request.getParameter("name");
		String phno=request.getParameter("phno");
		Contact contact=new Contact(name,phno);
		String result = service.addContact(contact);
		HttpSession session = request.getSession();
		System.out.println(result);
		session.setAttribute("result", result);
	    RequestDispatcher rd= request.getRequestDispatcher("Addcontact.jsp");
	    rd.forward(request, response);
			}
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		PrintWriter out=response.getWriter();
		contactList=service.getContact();
		out.println("<html>"+"<head>"+"<title>Contact List</title>"+"</head>"+"<body align=center>"+"<h1>Contact List</h1>");
		out.println("<table>"+"<tr>"+"<th>Sl.No</th>"+"<th>Name</th>"+"<th>Phno</th>"+"</tr>");
		for(int i=0;i<contactList.size();i++){
			out.println("<tr>"+"<td>");
			out.println(i+1);
			out.println("</td>"+"<td>");
			out.println(contactList.get(i).getName());
			out.println("</td>"+"<td>");
			out.println(contactList.get(i).getPhno());
			out.println("</td>"+"</tr>");
		}
		out.println("</table>"+"</body>"+"</html>");
	}
}