<html>
<head>
<%@ page import="java.util.*" %>
	<title>Contact saved page</title>
</head>
<body>
<style>
body{
	background-image:url("80220.jpg");
}
h1{
	color:cyan;
}
h2{
	color:lime;
}
r{
	color:MediumVioletRed;
}

</style>
<h1 align="center">Contacts</h1>
<%
	String n1,n2;
	n1=(String)request.getParameter("param1");
	n2=(String)request.getParameter("param2");
	%>
	<!--Contact c=new Contact();-->
	
	
	<h2> Contact is </h2>
	<r>
	<%
	ArrayList al=new ArrayList();
	al.add(n1);
	al.add(n2);
	out.print(n1+"<br>"+n2);
%>
</r></br></br></br>
<form action="Contacts.jsp">
<center>
	<input type="SUBMIT" value="HOME"/>
	</center>
</form>
</body>
</html>
	

