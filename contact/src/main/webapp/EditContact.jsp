<%@ page import = "com.lxisoft.model.ContactDetails" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit Contact</title>
<script type="text/javascript">
			function validateEmail()
			{
			 var email = document.getElementById("e").value;
			 var mob = document.getElementById("m").value;
			 var reg = /^([A-Za-z0-9\.-_]+)@([A-Za-z0-9]+).([a-z{2,4}]+)$/;
			 var regm = /(9|8|7)[0-9]{9,9}/;
			 if (reg.test(email)&&regm.test(mob)){
				  	document.getElementById("el").innerHTML = "Valid Email ID"
				 	document.getElementById("el").style.visibility = "visible";
					document.getElementById("e").style.border = "2px solid green";
					document.getElementById("el").style.color = "green";
					document.getElementById("ml").style.visibility = "visible";
					document.getElementById("ml").innerHTML = "Valid Mobile Number"
					document.getElementById("m").style.border = "2px solid green";
					document.getElementById("ml").style.color = "green";
			 	 return true;
			 }
			 else{
				if(reg.test(email)==false&&regm.test(mob)==false){
					document.getElementById("el").style.visibility = "visible";
					document.getElementById("e").style.border = "2px solid red";
					document.getElementById("ml").style.visibility = "visible";
					document.getElementById("m").style.border = "2px solid red";
					return false;
				}
				if(reg.test(email)==true&&regm.test(mob)==false){
				 		document.getElementById("el").innerHTML = "Valid Email ID"
					 	document.getElementById("el").style.visibility = "visible";
						document.getElementById("e").style.border = "2px solid green";
						document.getElementById("el").style.color = "green";
						document.getElementById("ml").style.visibility = "visible";
						document.getElementById("m").style.border = "2px solid red";
						return false
				}
				if(regm.test(mob)==true&&reg.test(email)==false){
			 		document.getElementById("ml").innerHTML = "Valid Mobile Number"
				 	document.getElementById("ml").style.visibility = "visible";
					document.getElementById("m").style.border = "2px solid green";
					document.getElementById("ml").style.color = "green";
					document.getElementById("el").style.visibility = "visible";
					document.getElementById("e").style.border = "2px solid red";
					return false
			}
			 }
			}
		</script>
</head>
<body>
	<%
	String contact = (String) request.getParameter("id");
	String data[] = contact.split(",");
	%>
	<form name = "addc" class = "cform" action = "editcontact">
	<h1 class ="h1"> ContactApp</h1>
		
		<input class = "search" type="text" name="name" value = <%=data[0]%> placeholder="Contact Name" required/>
		
		<br>
		<br>
		<input id ="e" class = "search" type="text" name="emailid" value = <%=data[1]%> placeholder="Email ID" style="border: 2px solid black;"/>
		<br>
		<center><label id = "el" style="color: red; visibility: hidden ;font-family: 'Roboto Condensed', sans-serif;">Invalid Email</label></center>

		<input id ="m" class = "search" type="text" name="number" value = "<%=data[2]%>" placeholder="Phone Number" style="border: 2px solid black;">
		<center><label id = "ml" style="color: red; visibility: hidden ;font-family: 'Roboto Condensed', sans-serif;">Invalid Mobile Number</label></center>
		<input type="hidden" name="id" value="<%=data[3]%>" />
		<button class = "addcb" type = "submit" title = "Edit Contact" onclick= "return validateEmail()">Edit Contact</button>
	</form>
</body>
</html>