<html>
<!--contacts app-->

<head>
	<title>Home</title>
</head>
<style>
	body
	{
		background-color:lightpink;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>

<body>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsApp/images/home.jpg" width="50" height="50"></a></br></br>
</p>



<h1>Result</h1>
<p align="right">
<img src="/ContactsApp/images/contacts.jpg" width="140" height="150">

</p>
<%   
String uname=request.getParameter("unname");  
out.println("welcome "+uname);  
%>

<%
response.sendRedirect("http://www.google.com");  
%>
	

</body>
</html>