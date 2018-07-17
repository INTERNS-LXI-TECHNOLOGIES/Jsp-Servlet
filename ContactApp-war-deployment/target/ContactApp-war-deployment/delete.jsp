<html>
<!..delete contact..>
<head>
<title>Delete Contact</title>
</head>

<%@ page import  = "java.sql.*"%>
<%@ page contentType = "text/html"%>
<%@ page pageEncoding = "UTF-8"%>
<%
String name = request.getParameter("name");
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
Statement stmt = con.createStatement();

String sql = "delete from contacts where name = 'name'";
try{
ResultSet rs = stmt.executeQuery(sql);
}catch(Exception e)
{
	e.printStackTrace();
}
%>
<style>
body
{
	background-color:lightblue;
}
</style>
<body>
<p>
<a href = "loginPage.jsp" >
<img src = "images/home.png" align = "left" alt = "home" title = "home" width = "50px">
</a>
</p>
<p>
<h1>Contact is deleted</h1>
</p>
</body>
</html>