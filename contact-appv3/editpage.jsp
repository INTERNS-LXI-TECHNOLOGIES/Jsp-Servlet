<!DOCTYPE html>
<html>
<head>
	<title>Edit</title>
	<%@ page import="java.util.*" %>
</head>
<body>
	<% ArrayList<String> list=(ArrayList<String>) request.getAttribute("list");%>
	<form action=EditContact method=post>
		
		Name :<input type=text name=name value="<%=list.get(0)%>">
		Phone :<input type=tel name=phno value="<%=list.get(1)%>">
		<button type=submit>Update</button>
	</form>

</body>
</html>