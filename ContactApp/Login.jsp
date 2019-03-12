<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
</head>
<style>
		body
			{ 
			background-color:cyan;
			}
	</style>
<body>
<%String name=(String) request.getAttribute("name"); %>
 <form method = "Get" action ="DeleteContact">
         <table>
            <tr>
               <td>Login</td>
               <td><input type = "text" name="username"></td>
            </tr>
            <tr>
               <td>Password</td>
               <td><input type = "password" name="password"></td>
            </tr>
         </table>
         <input type="hidden" name="name">
         <input type = "submit" value = "Login">
         
      </form>
</body>
</html>