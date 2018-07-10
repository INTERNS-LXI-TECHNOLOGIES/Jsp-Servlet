<html>
<!--contacts app-->

<head>
	<title>Edit</title>
	<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*,java.sql.*" %>
</head>
<h1>Edit Contact<h1>
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


<body>
    <% String name=request.getParameter("name");
	String oldName=name;
	
	
	
	
	
	
	try{
			Connection conn = null;
			Statement stmt = null;
			
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/contact", "root", "root");
				stmt = conn.createStatement();
				
				//List<Contact> contacts = new ArrayList<Contact>();
			String sql = "SELECT * FROM contable where name='"+name+"'";
		   ResultSet rs = null;
		   
			rs = stmt.executeQuery(sql);
				
					
					while(rs.next()){
					
					%>
	
	
	
	


 <form action="EditContact.jsp" method="post">

<table>
 
<tr>
	<td>Name:</td>
	<td><input type="text"  value="<%=rs.getString("name")%>" name="name"/></td>
<tr>
	<td>Phone:</td>
	<td><input type="text" value="<%=rs.getString("phoneNumber")%>" name="phoneNumber"/></td>
	
</tr>
<tr>
	<td>Place:</td>
	<td><input type="text" value="<%=rs.getString("place")%>" name="place"/></td>
	
</tr>

<tr>
	<td>e-mail:</td>
	<td><input type="text" value="<%=rs.getString("emailID")%>" name="e-mail"/></td>
	
</tr>

<tr align="center">
	<td colspan="2">
		<input align="center" type="submit" value="Submit" class="button" >
		<input  type="reset" value="Cancel" class="button" >
		
	</td>
</tr>  
<input type="hidden" value="<%=oldName%>" name="oldName"/> 
</table>
</form>
	<%
					}
	}catch(Exception e){
				out.println(e);
		}
	
	
	

	%>	
</body>
</html>