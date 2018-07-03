<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*"%>
<html>
<head></head>
<body>
<div style="width;100%;height:250px;background:lightblue">
<img style="align:center;width:200px;height:200px;margin-left:550px;margin-top:20px;" src="Android-Contacts-small.png"></img>
</div>


<table style="background: lightblue;margin-left: 170px;margin-top:40px; width: 70%; height: 100px; font-size: 24px; color: #fff; text-align: center;">
<tr><th>Name</th><th>Place</th><th>Phone Number</th><th>Email</th></tr>
<%
try{
	Object o=request.getAttribute("cont");
	TreeSet contacts=(TreeSet)o;
	for(Object obj:contacts)
	{
		Contact c=(Contact)obj;
		String nam=c.getName();
		String pla=c.getPlace();
		String phNo=c.getPhoneNumber();
		String ema=c.getEmail();
	
%>
<tr><td><%=c.getName()%></td><td><%=c.getPlace()%></td><td><%=c.getPhoneNumber()%></td><td><%=c.getEmail()%></td><td><a href="editContact.jsp?name=<%=nam%>&place=<%=pla%>&phoneNumber=<%=phNo%>&email=<%=ema%>">Edit it</a></td><td><a href="servletDeleteContact?name=<%=nam%>&place=<%=pla%>&phoneNumber=<%=phNo%>&email=<%=ema%>">Delete it</a></td></tr>

<%
	}
}
catch(Exception ex)
{
	ex.printStackTrace();
}
%>
</table>
</body>
</html>