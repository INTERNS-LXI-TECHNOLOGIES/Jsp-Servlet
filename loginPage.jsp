<html>
<!-- html login page -->
<head>
<title>Login Page</title>
<link rel = "stylesheet" type = "text/css" href = "sample.css"/>
</head>
<style>
body
{
	background-color:cornflowerBlue;
}
.button1
{
	background-color:cornflowerBlue;
	align:center;
}
.buttton1:hover
{
	background-color:blue;
}


</style>



<body>
<h1>&nbsp</h1>
<h1>Contacts</h1>

<p align="center">


<img src="images/contacts.jpg" alt = "contact image" width="150px"/>
</p>
<a href = "AddContact.jsp" target = "_blank" > 
<div id = "add">
<p align ="left">

<img src = "images/addcontact.jpg" alt = "add contacts" title = "Add contact" width = "50px"/>

</div></a>
<img src = "images/remove-user.jpg" align = "right" alt = "delete contact" title = "Delete contact" width = "50px">
</p>




<form action = "SearchContact.jsp" >
<input name = "search icon" type = "text" placeholder="Search here:"/>
<input type = "image" src = "images/search-contact-icon_1626595.jpg" alt = "search icon" title = "Search contact" width = "30"height = "30"/>
</form>


<%@ page import = "com.lxisoft.controller.*"%>
<%@ page import = "java.util.*"%>
<%@ page import = "com.lxisoft.model.*"%>
<%
ContactFile cf = new ContactFile();
String[] data = cf.readData();
if(data.length!=null)
{	
 for(i = 0;i<data.length;i++)
 {
%>

<input type = "button" class = "button1" value = "<%=data[i]%>"/>
<%
 }
}
%>



</body>
</html>


