<html>
<!--contacts app-->

<head>
	<title>Edit</title>
	<%@ page import="com.lxisoft.controller.*,com.lxisoft.model.*,java.util.*" %>
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
<a href="Contact.jsp"><img src="/ContactsApp/images/homePic.jpg" width="50" height="50"></a></br></br>
</p>


<body>
<%@ page import="java.util.*,com.lxisoft.controller.*,com.lxisoft.model.*,java.sql.*"%>
    <%
try{
	
	
    String name=request.getParameter("name");
	String oldName=name;
	
	//out.println(""+name);
	
	
	
		Connection conn = null;
		Statement stmt = null;
		Class.forName("com.mysql.jdbc.Driver");
		conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbcontact", "root", "root");

		stmt = conn.createStatement();
		String sql = "select * from contacts where name='"+name+"'";
		
		ResultSet rs = null;
		rs = stmt.executeQuery(sql);
		while(rs.next()){
			
			

       

			
			%>	
	
	
	

 <form action="EditContact.jsp" method="get">

<table>
 
<tr>
	<td>Name:</td>
	<td><input type="text" "First Name"  value="<%=rs.getString("name")%>" name="name"/></td>
<tr>
	<td>Phone:</td>
	<td><input type="text" value="<%=rs.getString("phone")%>" name="phone"/></td>
	
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
		}

catch(Exception e)
			{
				System.out.println(e);
			}%>
	
</body>
</html>