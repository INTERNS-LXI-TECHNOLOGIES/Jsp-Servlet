<html>
<%@ page import="com.lxisoft.model.*"%>
	<title>
	home page
	</title>
	<head></head>
	<body>
	<%
		Contact c=(Contact)session.getAttribute("contactSession");
	%>
	<form action="servletAddContact" method="post">
	
			<table cellspacing="10" style="background: lightblue;margin-left: 250px;margin-top:100px; width: 50%; height: 100px; font-size: 24px; color: #fff; text-align: center;">
				<tr><th colspan="2"><h2>Add Contact</h2></th></tr>
				<tr><td>Name:</td><td><input type="text" name="name" value="<%=c.getName()%>" required></td></tr>
				<tr><td>Place:</td><td><input type="text" name="place" value="<%=c.getPlace()%>" required></td></tr>
				<tr><td>Phone Number:</td><td><input type="text" name="phoneNumber" value="<%=c.getPhoneNumber()%>" pattern="\d{10}" required></td></tr>
				<tr><td>Email:</td><td><input type="email" name="email" value="<%=c.getEmail()%>" required></td></tr>
				<tr><td><input type="submit" name="submit" value="submit"></td><td><input type="button" name="cancel" value="cancel"></td></tr>
			</table>

	</form>
	</body>
	
</html>