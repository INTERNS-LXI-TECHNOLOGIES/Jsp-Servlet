<html>
<head><title>Error page</title><head>
<style>
body{
background-color:lightblue;
}
</style>
<body>
<font size = '5' color = 'red'>Invalid Username and Password</font>
<%@ page import = "java.sql.*"%>
<%String direction = "SecurityLogin.jsp";%>
 <%response.sendRedirect("SecurityLogin.jsp");%>//to get one more chance

</body>
</html>