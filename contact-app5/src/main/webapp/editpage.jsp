<!DOCTYPE html>
<html>
<head>
	<title>Edit</title>
	<%@ page import="java.util.*" %>
</head>
<body bgcolor="	#98FB98">

	<% ArrayList<String> list=(ArrayList<String>) request.getAttribute("list");

		String sname=(String) request.getAttribute("name1");

	%>
	<form action=EditContact method=post>
		<% request.setAttribute("sname",sname);%>
		Name :<input type=text name=name value="<%=list.get(0)%>">
		Phone Number :<input type=tel name=phno value="<%=list.get(1)%>">
		<input type="hidden" value="<%=sname%>" name="sname"/>
		<button type=submit>Update</button>
	</form>

</body>
</html>