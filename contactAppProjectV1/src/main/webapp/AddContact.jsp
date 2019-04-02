<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="style.css">
<title> Add Contact </title>
</head>

<%@  page import = "com.lxisoft.web.*,java.util.*,com.lxisoft.model.*,javax.servlet.ServletException,javax.servlet.http.* "%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<body class="body">
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
			 else{if(reg.test(email)==false&&regm.test(mob)==false){
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
					return false}
			 	}
			}</script>
	<% 		
	 Locale l = null;
	if((String)request.getAttribute("lang") != null){
	l = new Locale((String)request.getAttribute("lang"),(String)request.getAttribute("cont"));
	}
	else{
	l = new Locale("ml","IN");
	}
	boolean a = false;
	ResourceBundle r = ResourceBundle.getBundle("lang",l);
	
	%>
			

		<%Object c=application.getAttribute("contactapp"); %>
		<h1 class="body"><b><%=c %></i></h1></br>	
		<h2><i><%=r.getString("addcontact")%></i></h2></br>


		<form action ="Add" method="post">
		<input class="input" type="text"   placeholder="<%=r.getString("firstname") %>" name= "first_Name" required/><br/></br>
		<input class="input" type="text"  placeholder="<%=r.getString("lastname") %>" name= "last_Name" required/><br/></br>
		<select name="phone">  
		<option>Land-Line</option>  <option>Mobile</option>  
		<option>Other</option>  </select></br></br>
		<input  class="input" id="m" type="tel" placeholder="<%=r.getString("phonenumber") %>" name="number" required/></br>
		<center><label id = "ml" style="color: red; visibility: hidden ;font-family: 'Roboto Condensed', sans-serif;">Invalid Mobile Number</label></center></br>
		<input class="input" id="e" type="email"  placeholder="abc@example.com" name="email"/></td></tr></br>
		<center><label id = "el" style="color: red; visibility: hidden ;font-family: 'Roboto Condensed', sans-serif;">Invalid Email</label></center><br>
		<button class="buttonStyle" type="submit" onclick= "return validateEmail()"><%=r.getString("save") %></button><button class="buttonstyle" type="reset"><%=r.getString("reset") %></button></form><br><br>

	   
	<% 
	Object rs=session.getAttribute("result");
	if(rs=="Save")
	{%>
		<b><% out.println("Saved Successfully");%></b>
	
	<%}
	session.setAttribute("result",null);
	%>
	
<a href="Home.jsp"><center><img src="/contactAppProjectV1/images/homeIcon.ico" height="30" width></a>
<div align=left>

	<button  class="button" onclick="window.location.href='lang?l=false'">Eng</button>
	<button  class="button" onclick="window.location.href='lang?l=true'">Mal</button>
</div>
</body>

</html>