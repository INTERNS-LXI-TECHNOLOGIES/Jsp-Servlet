<!DOCTYPE html>
<html>
<head>
<title> Add Contact </title>
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
	</style>
	

<%@  page import = "com.lxisoft.contactapp.web.*,com.lxisoft.contactapp.service.*,java.util.*,com.lxisoft.contactapp.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>

<body>
	
	<h1><i>Delete Contact</i></h1></br>
	<form action ="Delete" method="Get">
	<% String name= (String) pageContext.getAttribute("sName", pageContext.SESSION_SCOPE);%>
	Name:<input type="text"  name= "dName" value="<%=name%>"/></br></br>
	<button class="buttonStyle" type="submit">Delete</button><input type="reset" value="Cancel"/><br><br>
	  	<% 
			
	Object rs=null;
	
	rs=session.getAttribute("result");
	if(rs=="delete")
	{
	%>
		<b><% out.println("Deleted");%></b>
	
	<%}
	session.setAttribute("delete",null);
	%>
	</form>
	<a href="AddContact.jsp"><center><img src="/contactappv1/images/add3.jpg" height="30" width></a>
    <a href="Home.jsp"><img src="/contactappv1/images/homeIcon.ico" height="30" width></a>

</body>

</html>