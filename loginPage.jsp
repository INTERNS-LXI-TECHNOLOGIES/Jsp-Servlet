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

</p>
<%@ page import = "java.util.*"%>
<%@ page contentType = "text/html"%>
<%@ page pageEncoding = "UTF-8"%>
<%@ page import = "java.io.*"%>
<%@ page import = "com.lxisoft.model.*"%>

<%

try{

Properties prts = new Properties();
InputStream input = null;
input = getClass().getClassLoader().getResourceAsStream("MyLabels.properties");
Reader reader = new InputStreamReader(input,"UTF-8");
prts.load(reader);
out.println(prts.getProperty("malayalam"));
out.println("|");
out.println("English");
}catch(IOException ex)
{
	ex.printStackTrace();
}

%>




<form action = "SearchContact.jsp" >
<input name = "search icon" type = "text" placeholder="Search here:"/>
<input type = "image" src = "images/search-contact-icon_1626595.jpg" alt = "search icon" title = "Search contact" width = "30"height = "30"/>
</form>

<% Object obj= session.getAttribute("contacts");
List<Contact> contacts=null;
 if(obj!=null)
 {
   contacts = (List<Contact>)obj;
   for(Contact contact:contacts)
{
%>
<div id = "name" align = "center">
<a href = "ContactsInformation.jsp?name=<%contact.getFirstName();%>">
<%out.println(contact.getFirstName());%>
</a>
<%}
 }else
 {
	 response.sendRedirect("ContactsAppServlet");
 }
 %>
</div>


</body>
</html>


