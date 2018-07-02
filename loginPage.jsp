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
<select >
</select>
<%
try{
File file = new File("MyLabels.properties");
FileInputStream fileInput = new FileInputStream(file);
Properties prts = new Properties();
prts.load(fileInput);
fileInput.close();

String value = prts.getProperty("malayalam");
out.println(value);
}catch(Exception e)
{
	e.printStackTrace();
}

%>




<form action = "SearchContact.jsp" >
<input name = "search icon" type = "text" placeholder="Search here:"/>
<input type = "image" src = "images/search-contact-icon_1626595.jpg" alt = "search icon" title = "Search contact" width = "30"height = "30"/>
</form>




</body>
</html>


