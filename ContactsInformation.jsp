<html>
<!..information>
<head>
<title>ContactsInformation</title>

<style>

body
{
	background-color:lightblue;
}
</style>
<%@ page import = "com.lxisoft.controller.*"%>
<%@ page import = "com.lxisoft.model.*"%>
<%@ page import = "java.util.*"%>
<%
String name = request.getParameter("name");
ContactFile ncc = new ContactFile();
Set<Contact> sets = ncc.readData();
if(sets!=null)
{
for(Contact setss:sets)
{
	if(name.equals(setss.getFirstName()))
	{

%>
<body>

<h1>Contacts Information</h1>
<p>

<img src = "images/remove-user.jpg" align = "right" alt = "delete contact" title = "Delete contact" width = "50px">
<a href = "editContact.jsp?name=<%=setss.getFirstName()%>&&place=<%=setss.getPlace()%>&&phn_no=<%=setss.getPhone_Number()%>&&mail=<%=setss.getEmail_Id()%> target = "_blank">
<img src = "images/editicon.jpg" align = "right" alt = "edit contact" title = "Update Contact" width = "50px">
</p>



<h1>&nbsp</h1>
<div id ="details" align = "center">
<input type = "text"  value = "<%=setss.getFirstName()%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=setss.getPlace()%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=setss.getPhone_Number()%>"/>
<h1>&nbsp</h1>
<input type = "text" value = "<%=setss.getEmail_Id()%>"/>
</div>
</p>
<%
	}
}
}
%>
</body>
</head>
</html>