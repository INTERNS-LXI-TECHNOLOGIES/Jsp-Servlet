import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import javax.servlet.annotation.WebServlet;
import java.util.ArraList;


public class AddContact extends HttpServlet{
	@Override

	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{

		ArrayList<Contact> list=new ArrayList<Contact>();
		String name=request.getParameter("name");
		String phno=request.getParameter("phno");

		Contact contact=new Contact(name,phno);
		list.add(contact);

	}
}