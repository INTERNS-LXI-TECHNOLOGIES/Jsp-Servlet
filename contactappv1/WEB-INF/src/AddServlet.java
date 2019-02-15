
import java.io.*;  
import java.sql.*;
import java.util.ArrayList;  
import javax.servlet.ServletException;  
import javax.servlet.http.*;   

public class AddServlet extends HttpServlet{
	

public void doGet(HttpServletRequest request,HttpServletResponse response){
ContactController contactControl=new ContactController();
		
response.setContentType("text/html");  
PrintWriter out = response.getWriter();  
System.out.println("@@@@@@@@@@@@@@@addContact");
String name=request.getParameter("userName");  
String phNumber=request.getParameter("phNumber");  
String email=request.getParameter("userEmail");  



contactControl.createContact(name,phNumber,email);

out.close();

}
}