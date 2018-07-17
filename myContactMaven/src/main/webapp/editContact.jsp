<html>
<body>
<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*"%>
<%
 String name=request.getParameter("name");
 String place=request.getParameter("place");
 String phoneNumber=request.getParameter("phoneNumber");
 String email=request.getParameter("email");
 
%>
<form action="servletEditContact" method="post">
			<table cellspacing="10" style="background: lightblue;margin-left: 250px;margin-top:100px; width: 50%; height: 100px; font-size: 24px; color: #fff; text-align: center;">
				<tr><th colspan="2"><h2>Edit Contact</h2></th></tr>
				<tr><td>Name:</td><td><input type="text" name="name" value="<%=name%>"></td></tr>
				<tr><td>Place:</td><td><input type="text" name="place" value="<%=place%>"></td></tr>
				<tr><td>Phone Number:</td><td><input type="text" name="phoneNumber" value="<%=phoneNumber%>"></td></tr>
				<tr><td>Email:</td><td><input type="text" name="email" value="<%=email%>"></td></tr>
				<input type="hidden" name="nameHidden" value=<%=name%>>
				<tr><td><input type="submit" name="submit" value="submit"></td><td><input type="button" name="cancel" value="cancel"></td></tr>
			</table>
</form>
</body>
</html>