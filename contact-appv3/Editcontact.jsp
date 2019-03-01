<!DOCTYPE html>
<html>
<head>
	<title>Edit</title>
</head>
<body bgcolor="#98FB98">
		<a href="Home.jsp">Home</a><br><br>
	<h1>Edit</h1>

	<form action="EditContact" method="get">Name: <input type="text" name="name"><button type="submit">Edit</button></form>
	<%
	Object rs=null;
		rs=session.getAttribute("result");
		if(rs=="update")
		{%>
			<b>
			<% out.println("Contact Updated"); %></b>
	   		<% session.setAttribute("result",null);
			
		}
	%>
</body>
</html>