<!DOCTYPE html>
<html>
<head>
<title> Home </title>
</head>
	<style>
		body
			{
			background-color:cyan;
			}
	</style>
<h1><center><b>CONTACT APP</h1>	
</head><body>
	<a href="AddContact.jsp"><center><img src="/contactappv1/images/add3.jpg" height="60" width></a>
  
    <a href="Login.jsp"><img src="/contactappv1/images/contacts.png" height="60" width></a>
    
	<%String contacts="CONTACTS"; %>
	<% application.setAttribute("contacts", contacts);%>
</body>
</html>