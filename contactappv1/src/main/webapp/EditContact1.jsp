<!DOCTYPE html>
<html>
<head>
<title>Contact </title>
</head>
	<style>
	
		body
			{
			background-color:cyan;
			}			
/* CSS */
.buttonStyle {
  color: #FFF;
  background: #999;
  font-weight: bold;
  border: 1px solid #900;
}
 
.buttonStyle:hover {
  color: #FFF;
  background: #900;
}
table, th, td {
	background-color: #f1f1c1;
    border: 1px solid black;
    border-collapse: collapse;
}
th {
  text-align: left;
}
	</style>
	

<%@  page import = "com.lxisoft.contactapp.web.*,java.util.*,com.lxisoft.contactapp.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>

	<h1><i>Edit Contact</i></h1></br>

	<%
	String oldName=(String) request.getAttribute("eName");
	Contact cont=(Contact)request.getAttribute("cont");
	%>
	
				<form action="Update" method="Post">
				<table>
				<tr><td>First Name:<input type="text" name="uFirstName" value="<%=cont.getFirstName()%>"/></td></tr>
				<tr><td>Last Name:<input type="text" name="uLastName" value="<%=cont.getLastName()%>"/></td></tr>
				<tr><td>Phone:
				<select name="uPhone">
				<option>Land-Line</option>
				<option>Mobile</option>
				<option>Other</option>
				</select>
				</td></tr>
				<tr><td>Number:<input type="tel" name="uNumber" value="<%=cont.getNumber()%>"/></td></tr>
				<tr><td>Email:<input type="email" name="uEmail" value="<%=cont.getEmail()%>"/></td></tr>
			
				<tr><td><input type="submit" value="Save"/></td></tr>
				<input type="hidden" name="oldName">
				</table>
				</form>
				
</body>

</html>