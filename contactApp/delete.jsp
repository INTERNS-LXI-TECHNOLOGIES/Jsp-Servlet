<%@ page import="com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
<html>
	<head>
	<link rel="stylesheet" href="delete.css">
	<link rel="stylesheet" href="homestyle.css">
	</head>
	<body>
	<%
		ContactRepository contactRepo=new ContactRepository();
		int flag=contactRepo.deleteFromDb(request.getParameter("firstName"));
		if(flag>0)
		{%>
			<div class="alert info">
			<span class="closebtn">&times;</span>  
			<strong>Success!</strong> One item is deleted from database.
			</div>
		<%}
		else
		{%>
			<div class="alert">
  <span class="closebtn">&times;</span>  
  <strong>Opps!</strong> There is no contact found for delete.
</div>
		<%}%>
	
<script>
var close = document.getElementsByClassName("closebtn");
var i;

for (i = 0; i < close.length; i++) {
  close[i].onclick = function(){
    var div = this.parentElement;
    div.style.opacity = "0";
    setTimeout(function(){ div.style.display = "none"; }, 600);
  }
}
</script>
<br><a href="home.html">Back to Home</a><br>
<a href="delete.html">Go Back</a>
	</body>
</html>