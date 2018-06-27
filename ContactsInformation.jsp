<html>
<!..information>
<head>
<title>ContactsInformation</title>

<style>

body
{
	background-color:lightblue;
}
</style>
<%@ page import = "java.sql.*"%>
<%@ page contentType = "text/html"%>
<%@ page pageEncoding = "UTF-8"%>
<%
String name = request.getParameter("name");
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select name,place,phn_no,email from contacts");
while(rs.next())
{
	if(name.equals(rs.getString("name")))
	{

%>
<body>

<h1>Contacts Information</h1>

<p>
<a href = "loginPage.jsp" >
<img src = "images/home.png" align = "left" alt = "home" title = "home" width = "50px">
</a>
<a href = "delete.jsp?name=<%=rs.getString("name")%>">
<img src = "images/remove-user.jpg" align = "right" alt = "delete contact" title = "Delete contact" width = "50px">
</a>

<a href = "editContact.jsp?name=<%=rs.getString("name")%>&&place=<%=rs.getString("place")%>&&phn_no=<%=rs.getString("phn_no")%>&&mail=<%=rs.getString("email")%>">
<img src = "images/editicon.jpg" align = "right" alt = "edit contact" title = "Update Contact" width = "50px">
</a>

</p>



<h1>&nbsp</h1>
<div id ="details" align = "center">
<label for = "text"  value = "<%=rs.getString("name")%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=rs.getString("place")%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=rs.getString("phn_no")%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=rs.getString("email")%>"/>
</div>
</p>
<%
	}
}

%>
</body>
</head>
</html>