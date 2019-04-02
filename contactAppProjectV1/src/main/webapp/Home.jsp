<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%@ page import = "java.io.*,java.util.Locale" %>
<%@ page import = "java.util.ResourceBundle" %>
<%@ page import = "javax.servlet.*,javax.servlet.http.* "%>
<%@ page import = "java.text.DateFormat,java.util.Date" %>

<title>Home</title>
<link rel="stylesheet" type="text/css" href="style.css">

	<script type="text/javascript">
	
	</script>
		<%Object c=application.getAttribute("contactapp"); %>
		<h1 class="h1"><b><%=c %></i></h1></br>	
	
</head>

<% Locale locale = request.getLocale();%>
<body class="body">
<% String title = "Locale Specific Dates";
   
   //Get the client's Locale
   String date = DateFormat.getDateTimeInstance( DateFormat.FULL,  DateFormat.SHORT,locale).format(new Date( ));%>
   
   	  <div align = "left">
         <p>Date: <%  out.print(date); %></p>
      </div>
	
	<a href="AddContact.jsp"><center><img src="/contactAppProjectV1/images/add3.jpg" height="40" width></a>
    
     <a href="Add"><img src="/contactAppProjectV1/images/contacts.png" height="40" width></img></a>
</body>
</html>