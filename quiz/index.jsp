<%@ page import="com.lxisoft.camp.Question" %>
<html>

<head>
 <link rel="stylesheet" href="style.css">
<title>Online Quiz</title>
</head>
<body>
<%
Question q=new Question();
out.println(q.printDetails());
%>
</body>
</html>