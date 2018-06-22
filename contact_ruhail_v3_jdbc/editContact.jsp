<html>
<body>
<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*"%>
<%
 String name=request.getParameter("name");
 ContactController contactController = new ContactController();
 Set<Contact> contacts=contactController.viewContact();
 String idName="";
 Contact con=null;
 for(Contact c:contacts)
 {
	if(name.equals(c.getName()))
	{
		con=c;
		idName=con.getName();
	}
 }
%>
<form action="editContactAction.jsp" method="post">
			<table cellspacing="10" style="background: lightblue;margin-left: 250px;margin-top:100px; width: 50%; height: 100px; font-size: 24px; color: #fff; text-align: center;">
				<tr><th colspan="2"><h2>Edit Contact</h2></th></tr>
				<tr><td>Name:</td><td><input type="text" name="name" value="<%=con.getName()%>"></td></tr>
				<tr><td>Place:</td><td><input type="text" name="place" value="<%=con.getPlace()%>"></td></tr>
				<tr><td>Phone Number:</td><td><input type="text" name="phoneNumber" value="<%=con.getPhoneNumber()%>"></td></tr>
				<tr><td>Email:</td><td><input type="text" name="email" value="<%=con.getEmail()%>"></td></tr>
				<input type="hidden" name="nameHidden" value=<%=idName%>>
				<tr><td><input type="submit" name="submit" value="submit"></td><td><input type="button" name="cancel" value="cancel"></td></tr>
			</table>
</form>
</body>
</html>