<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="style.css">
<title>Add Contact</title>
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
		
	<form name = "addc" class = "cform" action = "addcontacts">
	<h1 class ="h1"> ContactApp</h1>
		
		<input class = "search" type="text" name="name" placeholder="Contact Name" required/>
		
		<br>
		<br>
		<input id ="e" class = "search" type="text" name="emailid" placeholder="Email ID" style="border: 2px solid black;"/>
		<br>
		<center><label id = "el" style="color: red; visibility: hidden ;font-family: 'Roboto Condensed', sans-serif;">Invalid Email</label></center>

		<input id ="m" class = "search" type="text" name="number" placeholder="Phone Number" style="border: 2px solid black;">
		<center><label id = "ml" style="color: red; visibility: hidden ;font-family: 'Roboto Condensed', sans-serif;">Invalid Mobile Number</label></center>
		
		<button class = "addcb" type = "submit" title = "Add Contact" onclick= "return validateEmail()">Add Contact</button>
	</form>
</body>
</html>