
<%
	String user=request.getParameter("username");
	String pass=request.getParameter("password");
	session.setAttribute("sid", user);
	response.sendRedirect("home.jsp");
%>