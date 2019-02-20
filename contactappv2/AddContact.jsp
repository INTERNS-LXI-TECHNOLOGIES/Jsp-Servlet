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
	</style>	

<%@  page import = "com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*"%>
<body>

	<h2 align="center"><i>Add Contact</i></h2></br>

	<form action ="Add" method="post">
		Name:&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp<input type="text" name= "name"></br></br>
		Phone:&nbsp&nbsp&nbsp&nbsp&nbsp
		<select name="phone">  
		<option>Land-Line</option>  
		<option>Mobile</option>  
		<option>Other</option>  
		</select> </br></br>
		Number:&nbsp&nbsp&nbsp<input type="text" name="phNumber"/> </br></br>
		Email Id:&nbsp&nbsp<input type="text" name="userEmail"/> 
		
		
		</br></br>
	   <input align="left" type="submit"/> <input type="reset"/>
	</form>
		

<a href="Home.jsp"><center><img src="/contactappv2/images/homeIcon.ico" height="70" width></a>