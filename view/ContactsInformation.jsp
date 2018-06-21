<html>
<!..information>
<head>
<title>ContactsInformation</title>
<style>


</style>
<body>
<%@ page import = "com.lxisoft.controller.*"%>
<%@ page import = "com.lxisoft.model.*"%>
<%@ page import = "java.util.*"%>
<%
String name = request.getParameter("name");
NewContactController ncc = new NewContactController();
Set<Contact> sets = ncc.contactDisplay();
if(sets!=null)
{
for(Contact setss:sets)
{
	if(name.equals(setss.getFirstName()))
	{

%>
<input type = "text" value = "<%=setss.getFirstName()%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=setss.getPlace()%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=setss.getPhone_Number()%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=setss.getEmail_Id()%>"/>
<%
	}
}
}
%>
</body>
</head>
</html>