<html>
<!...new Contact with database..>
<%@ page contentType = "text/html"%>
<%@ page pageEncoding = "UTF-8"%>
<%@ page import = "java.sql.*"%> 
<%
String name  = request.getParameter("Name");
System.out.println("name"+name);
String place = request.getParameter("Place");
String phn_no = request.getParameter("Phn_no");
String email = request.getParameter("Email");
try
{
	System.out.println("database first");
	Class.forName("com.mysql.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
	
	PreparedStatement ps = con.prepareStatement("insert into contacts(name,place,Phn_no,Email) values(?,?,?,?)");
	ps.setString(1,name);
	ps.setString(2,place);
	System.out.println("database");
	ps.setString(3,phn_no);
	ps.setString(4,email);
	ps.executeUpdate();
	con.close();
}catch(Exception ex)
{
	out.println(ex);
}

String direction = "loginPage.jsp";
response.sendRedirect(direction);
%>

</html>