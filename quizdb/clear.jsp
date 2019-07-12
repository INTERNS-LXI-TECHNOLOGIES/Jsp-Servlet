<%@ page import="com.lxisoft.camp.Quiz" %>
<%
	Quiz newQuiz=new Quiz();
	session.setAttribute("quiz",newQuiz);
	response.sendRedirect("index.jsp");
%>
