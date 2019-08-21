<%@page import="com.lxisoft.contact.*"%>
<%@page import="java.sql.*" %>
<%@page import="java.io.*"%>
<!DOCTYPE html>
<html>
<head>
	<title>File uploading</title>
</head>
<body>
<h1>Upload</h1>
<form action="upload" method="post" enctype="multipart/form-data">
	Select File:<input type="file" name="fname">
	<input type="submit" name="submit" value="Submit">
</form>
</body>
</html>