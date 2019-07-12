<%@ page import="com.lxisoft.camp.Question" %>
<%@ page import="com.lxisoft.camp.Quiz" %>
<html>

<head>
 <link rel="stylesheet" href="style.css">
<title>Online Quiz</title>
</head>
<body>
<%
Quiz quizObj;
if(session.getAttribute("quiz")== null)
{
	quizObj=new Quiz();
	session.setAttribute("quiz",quizObj);
	
}
else
{
	quizObj=(Quiz)session.getAttribute("quiz");
}
	Question q=new Question();	
	q.setQuestion(request.getParameter("question"));
	q.setOption1(request.getParameter("option1"));
	q.setOption2(request.getParameter("option2"));
	q.setOption3(request.getParameter("option3"));
	q.setOption4(request.getParameter("option4"));
	q.setAnswer(request.getParameter("answer"));
	if(quizObj.q1==null)
	{
			
		quizObj.q1=q;
		// out.println(quizObj.q1.displayData());
		
	}
	else if(quizObj.q2==null)
	{
		
		quizObj.q2=q;
		// out.println(quizObj.q2.displayData());
		
	}
	else if(quizObj.q3==null) 
	{
		
		quizObj.q3=q;
		// out.println(quizObj.q3.displayData());
		
	}
	else if(quizObj.q4==null)
	{
			
		quizObj.q4=q;
		// out.println(quizObj.q4.displayData());
		
	}
	else
	{
		out.println("......Stack Overflow........");
	}

	


%>
<table border="1">
<tr>
<td>q1</td>

<td><%if(quizObj.q1==null) out.println("null"); else out.println(quizObj.q1.displayData());
	%></td>
</tr>
<tr>
<td>q2</td>
<td><%if(quizObj.q2==null) out.println("null"); else out.println(quizObj.q2.displayData());
	%></td>
</tr>
<tr>
<td>q3</td>
<td><%if(quizObj.q3==null) out.println("null"); else out.println(quizObj.q3.displayData());
	%></td>
</tr>
<tr>
<td>q4</td>
<td><%if(quizObj.q4==null) out.println("null"); else out.println(quizObj.q4.displayData());
	%></td>
</tr>
</table>
<a href="clear.jsp">clear</a>
<a href="index.html">go back</a>
</body>
</html>