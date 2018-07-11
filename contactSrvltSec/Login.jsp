<html>
   <head>
	<title>Home</title>
	<%@ page import="com.lxisoft.controller.*,java.util.*,com.lxisoft.model.*,java.sql.*"%>
</head>
<style>
	body
	{ 
		background-color:lightblue;
	}
	h1
	{
		color:White;
		text-align:center;
	}
	
	
</style>
<body>
<div id="top">
<h1>Contacts</h1>
<p align="center">
<img src="/ContactsDB/images/contacts.jpg" width="140" height="150"></br></br></br></br>
</p>
<link rel="stylesheet" type="text/css" href="Sample.css"/>
</div>
      
      <form method = "post" action ="j_security_check">
         <table border = "0">
            <tr>
               <td>Login</td>
               <td><input type = "text" name="j_username"></td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type = "password" name="j_password"></td>
            </tr>
         </table>
         <input type = "submit" value = "Login!">
         
      </form>
      
   </body>
</html>
