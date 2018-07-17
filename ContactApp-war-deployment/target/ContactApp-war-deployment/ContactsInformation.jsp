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
<%@ page import = "java.sql.*"%>
<%@ page contentType = "text/html"%>
<%@ page pageEncoding = "UTF-8"%>
<%@ page import = "java.util.*"%>
<%@ page import = "com.lxisoft.model.*"%>

<body>

<h1>Contacts Information</h1>


<p>
<a href = "loginPage.jsp" >
<img src = "images/home.png" align = "left" alt = "home" title = "home" width = "50px">
</a>


<%
String name = request.getParameter("name");
Object obj= session.getAttribute("contacts");
List<Contact> contacts=null;
 if(obj!=null)
 {
   contacts = (List<Contact>)obj;
   for(Contact contact:contacts)
{
	try{
		
	if(name.equals(contact.getFirstName())==true)
	{

%>

<a href = "delete.jsp?name=<%=contact.getFirstName()%>">
<img src = "images/remove-user.jpg" align = "right" alt = "delete contact" title = "Delete contact" width = "50px">
</a>

<a href = "editContact.jsp?name=<%=contact.getFirstName()%>&&place=<%=contact.getPlace()%>&&phn_no=<%=contact.getPhone_Number()%>&&mail=<%=contact.getEmail_Id()%>">
<img src = "images/editicon.jpg" align = "right" alt = "edit contact" title = "Update Contact" width = "50px">
</a>

</p>





<h1>&nbsp</h1>
<div id ="details" align = "center">
<label for = "name">  <%=contact.getFirstName()%>
<label/>
<h1>&nbsp</h1>
<label for = "place">
<%=contact.getPlace()%>
<label/>
<h1>&nbsp</h1>
<label for = "number">
<%=contact.getPhone_Number()%>
<label/>
<h1>&nbsp</h1>
<label for= "mail">
<%=contact.getEmail_Id()%>
<label/>
</div>
</p>
<%
	
	}}catch(Exception e) {
		e.printStackTrace();
	}
%>

<%
	
}
 }
%>
</body>
</head>
</html>