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
<%@ page import = "java.io.*,java.util.Locale" %>
<%@ page import = "javax.servlet.*,javax.servlet.http.* "%>
<%@ page import = "java.text.DateFormat,java.util.Date" %>
	<% Locale locale = request.getLocale();
	   String language = locale.getLanguage();
	   String country = locale.getCountry(); %>
<h1><center><b>CONTACT APP</h1>	
</head><body>

		<% 
            out.println("Language : " + language  + "<br />");
            out.println("Country  : " + country   + "<br />");
         %>
         
         <%
   String title = "Locale Specific Dates";
   
   //Get the client's Locale
   String date = DateFormat.getDateTimeInstance( DateFormat.FULL,  DateFormat.SHORT,locale).format(new Date( ));
%>
         <div align = "center">
         <p>Local Date: <%  out.print(date); %></p>
      </div>
 
	<a href="AddContact.jsp"><center><img src="/contactappv1/images/add3.jpg" height="60" width></a>
  
    <a href="Login.jsp"><img src="/contactappv1/images/contacts.png" height="60" width></a>
    
	<%String contacts="CONTACTS"; %>
	<% application.setAttribute("contacts", contacts);%>
</body>
</html>