<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<title>Contact </title>
</head>

<%@  page import = "com.lxisoft.web.*,java.util.*,com.lxisoft.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body class="body">
	<%Object c=application.getAttribute("contactapp"); %>
	<h1 class="h1"><b><%=c %></i></h1></br>	
	<h3><i>Edit Contact</i></h1></br>

	<%
	ArrayList<String> conlist=new ArrayList<String>();
	conlist=(ArrayList<String>)request.getAttribute("list");
	
	
		%>
	
				<form action="Edit" method="Post">
				<table>
				<tr><td><input class="input" type="text" name="uFirstName" value="<%=conlist.get(0)%>"/></td></tr>
				<tr><td><input class="input" type="text" name="uLastName" value="<%=conlist.get(1)%>"/></td></tr>
				<tr><td><input class="input" type="text" name="uPhone" value="<%=conlist.get(2) %>"/></td></tr>
				<tr><td><input class="input"type="tel" name="uNumber" value="<%=conlist.get(3)%>"/></td></tr>
				<tr><td><input class="input" type="email" name="uEmail" value="<%=conlist.get(4)%>"/></td></tr>

				<tr><td><input class="button" type="submit" value="Save"/></td></tr>
				</table>
				</form><br><br>

		<a  href="AddContact.jsp"><center><img src="/contactAppProjectV1/images/add3.jpg" height="30" width></a>
		<a  href="Home.jsp"><img src="/contactAppProjectV1/images/homeIcon.ico" height="30" width></a>
				
				
</body>

</html>