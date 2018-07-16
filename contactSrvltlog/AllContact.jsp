<html>
<!--contacts app-->

<head>
	<title>All Contacts</title>
	
</head>
<style>
	body
	{
		background-color:skyblue;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>


<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*,java.sql.*"%>

	<% try{
		
		
		ArrayList<Contact> ct =(ArrayList<Contact>)request.getSession().getAttribute("Contact");
		
		%>
		
	

    
			
			<body>
			</p>
<h1>All Contacts</h1>
<p align="center">
<img src="/ContactSDB/images/contacts.jpg" width="140" height="150">
</p>
<p align="left">
<a href="Contact.jsp"><img src="/ContactsDB/images/home.jpg" width="50" height="50"></a></br></br>
</p>

<%for(Contact cnts:ct){
		%>


			
				<%out.println(">>>>>"+cnts.getName());%></br>
		<%out.println(">>>>>"+cnts.getPhoneNumber());%></br>
		<%out.println(">>>>>"+cnts.getPlace());%></br>
		<%out.println(">>>>>"+cnts.getEmailId());%></br></br></br>
					
				
				
				<%}
		}catch(Exception e){
				out.println(e);
		}
	
	%>
				

</body>




</html>