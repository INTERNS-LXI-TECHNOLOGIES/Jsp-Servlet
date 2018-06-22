<html>
<!--contacts app-->

<head>
	<title>Home</title>
	<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*"%>
</head>
<style>
	body
	{ 
		background-color:lightblue;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>

<body>
<div id="top">
<h1>Contacts</h1>
<p align="center">
<img src="/ContactsApp/images/contacts.jpg" width="140" height="150"></br></br></br></br>
</p>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>

<!--
<form>-->
	
	
	
	<!--input type="text"/-->
	<a href="AddContact.jsp"><img src="/ContactsApp/images/addContact.jpg" width="50" height="50" title=addContact></a></br></br>
	
	<!--<a href="Result.jsp"><img src="/ContactsApp/images/images.jpg" width="30" height="30"></a>
	<input type="text" placeholder="search here"/>
	
</form>	-->
<form action="Details.jsp" >


<input type="text" name="name" placeholder="search here">
<input type="submit" value="go"></br>
</form>



<div id="contact">
		
		
		
		
		<%ContactController cc=new ContactController();
		Set<Contact> contactList=cc.getContacts();
		collections.sort(contactList);
			for(Contact b:contactList){
			
			%>

				<a href="Details.jsp?name=<%=b.getName()%>"><%out.println(b.getName());%></br></a>
				
				<%
			}
		
		
		%>
		
			
		
		
			
		
		
</div>
</body>
</html>