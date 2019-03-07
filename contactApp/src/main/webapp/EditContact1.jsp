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
	ArrayList<Contact> conlist=new ArrayList<Contact>();
	conlist=(ArrayList<Contact>)request.getAttribute("contacts");
	String editName=request.getParameter("editName");
		for(Contact cont:conlist){
			if(cont.getName().equals(editName)){
				String phone=cont.getPhone();
				String number=cont.getNumber();
				String email=cont.getEmail();%>
				<form action="Update" method="post">
				<table>
				<tr><td>Name:<input type="text" name="updateName" value="<%=cont.getName()%>"/></td></tr>
				<tr><td>Phone:
				<select name="updatePhone">
				<option>Land-Line</option>
				<option>Mobile</option>
				<option>Other</option>
				</select>
				</td></tr>
				<tr><td>Number:<input type="tel" name="updateNumber" value="<%=number%>"/></td></tr>
				<tr><td>Email:<input type="email" name="updateEmail" value="<%=email%>"/></td></tr>
			<%}
		}%>
			
				<tr><td><input type="submit" value="Save"/></td></tr>
				</table>
				</form>
				
</body>

</html>