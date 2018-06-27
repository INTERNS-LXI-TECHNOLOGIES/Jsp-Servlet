<html>
<%
if(((String)session.getAttribute("sid"))!=null)
{
%>
	<head>
		<title>
	home page
	</title>
	</head>
	<body>
		<a href="addContact.jsp">
			<div id="main" style="margin: 30px; width: 27%; height: 350px; background: lightblue;  float: left; border-left: 10px solid #fff;">
			<img style="margin:20px;" src="Add-Male-User-icon.png"></img>
			<center><h2>Add Contact</h2></center>
			</div>
		</a>
			
		<a href="searchContact.jsp">
			<div id="main" style="margin: 30px; width: 27%; height: 350px; background: lightblue;  float: left; border-left: 10px solid #fff;">
			<img style="margin:45px;" src="search_10.png"></img>
			<center><h2>Search Contact</h2></center>
			</div>
		</a>
			
		<a href="servletViewContact">
			<div id="main" style="margin: 30px; width: 27%; height: 350px; background: lightblue;  float: left; border-left: 10px solid #fff;">
			<img style="margin:15px; width:270px;" src="Google_Contacts_logo.png"></img>
			<center><h2>View Contact</h2></center>
			</div>
		</a>
		
	</body>
	<%
}
else
{
	response.sendRedirect("login.jsp");
}
	%>
</html>