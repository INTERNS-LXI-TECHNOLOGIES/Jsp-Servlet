<html>
<head>
<title>Edit Contact</title>
</head>





<body>


<%
String name=request.getParameter("name");
String place =request.getParameter("place");
String phn_no=request.getParameter("phn_no");
String email=request.getParameter("mail");
%>
<div id = "test" align = "center">
<form action= "" method = "post">
<table>
<tr>
	<td>
		<label for  = "Name">Name:</label>
	</td>
	<td>
		<input name = "Name" type = "text"  value = "<%=name%>"/>
	</td>
</tr>
<tr>
	<td>
		<label for = "Place">Place:</label>
	</td>
	<td>
		<input name = "Place" type = "text" value="<%=place%>"/>
	</td>
</tr>
<tr>
	<td>
		<label for = "Phn_no">Phone Number:</label>
	</td>
	<td>
		<input name = "Phn_no" type = "text" value=<%=phn_no%>/>
	</td>
</tr>
<tr>
	<td>
		<label for = "email">Email:</label>
	</td>
	<td>
		<input name = "Email" type = "text" value=<%=email%>/>
	</td>
	
	</tr>
	
</table>


</br>	
	<input type = "submit" class = "button" name = "submit" value= "submit" />
	<input type = "reset" class = "button" name = "cancel" value ="Cancel">
	

</form>
</div>


</body>
</html>