
<!DOCTYPE html>
<html>
<head>
	<title> Add Details</title>
<%@page import="java.util.ResourceBundle,java.util.Locale" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
</head>
<body bgcolor="	#98FB98">
<%
	Locale l=null;
	if((String)request.getAttribute("lang")!=null){
		l=new Locale((String)request.getAttribute("lang"));
	}
	else{
		l=new Locale("eng");
	}
	ResourceBundle r=ResourceBundle.getBundle("lang",l);
%>

	<a href="Home.jsp"><%=r.getString("Home")%></a>
	<div style="display: flex; justify-content: center;">
	<img src="images/addContact.jpg" style="width: 400px; height: 200px;" />
</div>

	<h1 align="center"><%=r.getString("AddContact")%></h1>
<form align="center" method="post" action="AddContact">

	<%=r.getString("Name")%> :&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp
	<input type="text" name="name"><br><br>
	<%=r.getString("PhoneNumber")%>:&nbsp&nbsp&nbsp  <input type="tel" name="phno" pattern="^\d{10}" required><br><br>
	<button type="submit"><%=r.getString("Save")%></button><br><br>
	<input type="hidden" value="add" name="add">
	<button  class="eng" onclick="window.location.href='lang1?l=eng'" >English</button>
	<button  class="mal" onclick="window.location.href='lang1?l=mal'">മലയാളം</button>
	<button  class="hin" onclick="window.location.href='lang1?l=hin'">हिंदी</button>
	<br>
	<br>
		<% 
	Object rs=null;
	rs=session.getAttribute("result");
	if(rs=="insert")
	{%>
		<b><% out.println("Saved Successfully");%></b>
	
	<%
	session.setAttribute("result",null);
}
	
	%>
</form>
</body>
</html>