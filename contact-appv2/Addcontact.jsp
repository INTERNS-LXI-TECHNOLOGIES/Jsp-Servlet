<!DOCTYPE html>
<html>
<head>
	<title> Add Details</title>

</head>
<body>
	<a href="Home.jsp">Home</a>
	<div style="display: flex; justify-content: center;">
	<img src="data/addContact.jpg" style="width: 400px; height: 200px;" />
</div>
	<h1 align="center">Add Contact</h1>
<form align="center" method="post" action="AddContact">

	Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp<input type="text" name="name"><br><br>
	Phone Number: &nbsp&nbsp<input type="tel" name="phno" pattern="^\d{10}" required><br><br>
	<button type="submit">Save</button><br><br>
		<% 
	Object rs=null;
	rs=session.getAttribute("result");
	if(rs=="save")
	{%>
		<b><% out.println("Saved Successfully");%></b>
	
	<%}
	session.setAttribute("result",null);
	%>
</form>
</body>
</html>