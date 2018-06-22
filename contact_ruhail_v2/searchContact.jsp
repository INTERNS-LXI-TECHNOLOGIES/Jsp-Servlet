<html>
<body>
<div align="center">
<form action="searchContactAction.jsp" method="get">
<input type="text" placeholder="search here....." name="search">
<input type="submit" value="search" name="searching">
</form>
</div>
<%@ page import="java.util.*"%>
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
		String str=(String)obj;
		String[] contacts=str.split(",");
%>
<tr><td><%=contacts[0]%></td><td><%=contacts[1]%></td><td><%=contacts[2]%></td><td><%=contacts[3]%></td></tr>
<%
	}
}
%>
</table>
</body>
</html>