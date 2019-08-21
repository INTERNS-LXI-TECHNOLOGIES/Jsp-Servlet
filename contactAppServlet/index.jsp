<%@page import="com.lxisoft.contact.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>ContactApp</title>
</head>
<body>
<form action="Create.jsp" method="post">
	<input type="submit" value="Create">
</form>
<form action="Read.jsp" method="">
	<input type="submit" value="Read">
</form>
<form action="Update.jsp" method="post">
	<input type="submit" value="Update">
</form>
<form action="Delete.jsp" method="post">
	<input type="submit" value="Delete">
</form>
<form action="UploadFile.jsp" method="post">
	<input type="submit" value="Upload">
</form>
</body>
</html>