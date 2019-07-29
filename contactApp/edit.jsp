<%@ page import="com.lxisoft.contact.*"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<html>

<head>
 <link rel="stylesheet" href="delete.css">
 <link rel="stylesheet" href="homestyle.css">
<title>Contact App</title>
</head>
<body>
<form action="view.jsp" method="get" >
<%

	Contact c=new Contact();	
	c.setFirstName(request.getParameter("firstName"));
	c.setLastName(request.getParameter("lastName"));
	c.setWorkPlace(request.getParameter("workPlace"));
	c.setPhoneNumber(request.getParameter("number"));
	String name=request.getParameter("oldName");
	ContactRepository contactRepo=new ContactRepository();
	int status=contactRepo.updateDB(c,name);
	
	if(status>0)
		{%>
			<div class="alert success">
			<span class="closebtn">&times;</span>  
			<strong>Success!</strong> Contact updated sucessfully.
			</div>
		<%}
		else
		{%>
			<div class="alert">
  <span class="closebtn">&times;</span>  
  <strong>Opps!</strong> Can't update the Contact.
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



<a href="home.html">Back to Home</a>
<a href="Edit.html">go back</a>
</form>
</body>
</html>