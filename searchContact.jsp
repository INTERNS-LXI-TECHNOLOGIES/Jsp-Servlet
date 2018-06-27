<html>
<body>
<div align="center">
<form action="servletSearchContact" method="get">
<input type="text" placeholder="search here....." name="search">
<input type="submit" value="search" name="searching">
</form>
</div>
<%@ page import="java.util.*,com.lxisoft.model.*"%>
<%
if(request.getAttribute("contacts")!=null)
{
%>
<table style="background: lightblue;margin-left: 170px;margin-top:40px; width: 70%; height: 100px; font-size: 24px; color: #fff; text-align: center;">
<tr><th>Name</th><th>Place</th><th>Phone Number</th><th>Email</th></tr>
<%
	Object o=request.getAttribute("contacts");
	TreeSet s=(TreeSet)o;
	for(Object obj:s)
	{
		Contact c=(Contact)obj;
%>
<tr><td><%=c.getName()%></td><td><%=c.getPlace()%></td><td><%=c.getPhoneNumber()%></td><td><%=c.getEmail()%></td></tr>
<%
	}
}

%>
</table>
</body>
</html>