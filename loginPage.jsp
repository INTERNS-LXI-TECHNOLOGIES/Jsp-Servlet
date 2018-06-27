<html>
<!-- html login page -->
<head>
<title>Login Page</title>
<link rel = "stylesheet" type = "text/css" href = "sample.css"/>
</head>
<style>
body
{
	background-color:cornflowerBlue;
}
.button1
{
	background-color:cornflowerBlue;
	align:center;
}
.buttton1:hover
{
	background-color:blue;
}


</style>



<body>
<h1>&nbsp</h1>
<h1>Contacts</h1>

<p align="center">


<img src="images/contacts.jpg" alt = "contact image" width="150px"/>
</p>
<a href = "AddContact.jsp" target = "_blank" > 
<div id = "add">
<p align ="left">

<img src = "images/addcontact.jpg" alt = "add contacts" title = "Add contact" width = "50px"/>

</div></a>

</p>




<form action = "SearchContact.jsp" >
<input name = "search icon" type = "text" placeholder="Search here:"/>
<input type = "image" src = "images/search-contact-icon_1626595.jpg" alt = "search icon" title = "Search contact" width = "30"height = "30"/>
</form>

<div id = "jdbcread" align = "center">
<%@ page import = "java.sql.*"%>
<%@ page contentType = "text/html"%>
<%@ page pageEncoding = "UTF-8"%>

<%
Class.forName("com.mysql.jdbc.Driver");
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3307/contactsapp","root","root");
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery("select name,place,phn_no,email from contacts");
%>
<tbody>
<%while(rs.next()){%>
<tr>
<td>

<a href = "ContactsInformation.jsp?name=<%=rs.getString("name")%>">
<%=rs.getString("name")%>
</a>
</td>
</tr>
</br>
<%}%>

</tbody>
</div>



</body>
</html>


