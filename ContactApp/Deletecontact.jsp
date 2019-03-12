<!DOCTYPE html>
<html>
<head>
	<title>Delete</title>
</head>
<body bgcolor="#F08080"><a href=Home.jsp>Home</a>
	<h1>Delete</h1>
	<form action="Login.jsp">Name: <input type="text" name="name"><button type="submit">Delete</button></form>
	<% 
		Object rs=null;
		rs=session.getAttribute("result");
		if(rs=="delete")
		{ %>
			<b> <% out.println("Contact Deleted");%></b>
	   		<% session.setAttribute("result",null);%>
			
		<%}%>
</body>
</html>