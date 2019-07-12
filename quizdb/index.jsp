<%@ page import="com.lxisoft.camp.Question" %>
<%@ page import="com.lxisoft.camp.Quiz" %>
<%@ page import="com.lxisoft.camp.DbConnection"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>

<html>

<head>
 <link rel="stylesheet" href="style.css">
<title>Online Quiz</title>
</head>
<body>
<%
Quiz quizObj;
	Question q=new Question();	
	q.setQuestionNo(Integer.parseInt(request.getParameter("questionNo")));
	q.setQuestion(request.getParameter("question"));
	q.setOption1(request.getParameter("option1"));
	q.setOption2(request.getParameter("option2"));
	q.setOption3(request.getParameter("option3"));
	q.setOption4(request.getParameter("option4"));
	q.setAnswer(request.getParameter("answer"));
	DbConnection con=new DbConnection();
	con.insert(q);
	

	ArrayList<Question> questions=con.selectFromDb();
	for(int i=0;i<questions.size();i++)
	{
		out.println("Question No :"+questions.get(i).getQuestionNo());%><br><%
		out.println("Question :"+questions.get(i).getQuestion());%><br><%
		out.println("Option1 :"+questions.get(i).getOption1());%><br><%
		out.println("Option2 :"+questions.get(i).getOption2());%><br><%
		out.println("Option3 :"+questions.get(i).getOption3());%><br><%
		out.println("Option4 :"+questions.get(i).getOption4());%><br><%
		out.println("Answer :"+questions.get(i).getAnswer());%><br><%
	}
	



%>


<a href="clear.jsp">clear</a>
<a href="index.html">go back</a>
</body>
</html>