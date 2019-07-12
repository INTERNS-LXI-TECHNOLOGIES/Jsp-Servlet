<%@ page import= "com.lxisoft.camp.Question,com.lxisoft.camp.Quiz"%>
<%@ page import="java.sql.*"%>
<html>
<head>
	<title>Quiz</title>
</head>
<body>


<%
Question q=new Question();
String question =request.getParameter("Question");
String option1 = request.getParameter("Option 1");
 String option2 = request.getParameter("Option 2");
String option3 = request.getParameter("Option 3");
String option4 = request.getParameter("Option 4");
String answer= request. getParameter("Answer");
Quiz quiz;
if(session.getAttribute("Quiz")==null)
{
 quiz= new Quiz();
	session.setAttribute("Quiz",quiz);
}
else
{
	quiz=(Quiz)session.getAttribute("Quiz");
	if(quiz.q1==null)
	{
		quiz.q1=new Question();
		quiz.q1.question=question;
		quiz.q1.option1=option1;
		quiz.q1.option2=option2;
		quiz.q1.option3=option3;
		quiz.q1.option4=option4;
		quiz.q1.answer=answer;
		out.print("bjgn"+q.print());
	}
	else if(quiz.q2==null)
	{
		quiz.q2=new Question();
		quiz.q2.question=question;
		quiz.q2.option1=option1;
		quiz.q2.option2=option2;
		quiz.q2.option3=option3;
		quiz.q2.option4=option4;
		quiz.q2.answer=answer;

	}
	else if(quiz.q3==null)
	{
		quiz.q3=new Question();
		quiz.q3.question=question;
		quiz.q3.option1=option1;
		quiz.q3.option2=option2;
		quiz.q3.option3=option3;
		quiz.q3.option4=option4;
		quiz.q3.answer=answer;

	}
	else if(quiz.q4==null)
	{
		quiz.q4=new Question();
		quiz.q4.question=question;
		quiz.q4.option1=option1;
		quiz.q4.option2=option2;
		quiz.q4.option3=option3;
		quiz.q4.option4=option4;
		quiz.q4.answer=answer;

	}
	else if(quiz.q5==null)
	{
		quiz.q5=new Question();
		quiz.q5.question=question;
		quiz.q5.option1=option1;
		quiz.q5.option2=option2;
		quiz.q5.option3=option3;
		quiz.q5.option4=option4;
		quiz.q5.answer=answer;

	}
	else
	{
		out.println("Your Session Is Over..");
	}
}



//out.println(q.print());
Quiz qz=(Quiz)session.getAttribute("Quiz");
%>
<table border="1">
<tr>
	<td> </td><td>question</td><td>option1</td><td>option2</td><td>option3</td><td>option4</td><td>answer</td>
</tr>
	<tr>
		<td>Q1</td>
		<td><%=qz.q1.question%></td>
		<td><%=qz.q1.option1%></td>
		<td><%=qz.q1.option2%></td>
		<td><%=qz.q1.option3%></td>
		<td><%=qz.q1.option4%></td>
		<td><%=qz.q1.answer%></td>
		
	</tr>
	
	<tr>
		<td>Q2</td>
		<td><%=qz.q2.question%></td>
		<td><%=qz.q2.option1%></td>
		<td><%=qz.q2.option2%></td>
		<td><%=qz.q2.option3%></td>
		<td><%=qz.q2.option4%></td>
		<td><%=qz.q2.answer%></td>
		
	</tr>
	
	<tr>
		<td>Q3</td>
		<td><%=qz.q3.question%></td>
		<td><%=qz.q3.option1%></td>
		<td><%=qz.q3.option2%></td>
		<td><%=qz.q3.option3%></td>
		<td><%=qz.q3.option4%></td>
		<td><%=qz.q3.answer%></td>
		
	</tr>
	
	<tr>
		<td>Q4</td>
		<td><%=qz.q4.question%></td>
		<td><%=qz.q4.option1%></td>
		<td><%=qz.q4.option2%></td>
		<td><%=qz.q4.option3%></td>
		<td><%=qz.q4.option4%></td>
		<td><%=qz.q4.answer%></td>
		
	</tr>
	
	<tr>
		<td>Q5</td>
		<td><%=qz.q5.question%></td>
		<td><%=qz.q5.option1%></td>
		<td><%=qz.q5.option2%></td>
		<td><%=qz.q5.option3%></td>
		<td><%=qz.q5.option4%></td>
		<td><%=qz.q5.answer%></td>
		
	</tr>
	

</table>
<% Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb","root","root");

	PreparedStatement ps= con.prepareStatement("insert into quiz(questionNo,question,option1,option2,option3,option4,answer) values(1,'"+quiz.q1.question+"','"+quiz.q1.option1+"','"+quiz.q1.option2+"','"+quiz.q1.option3+"','"+quiz.q1.option4+"','"+quiz.q1.answer+"');");

	 ps=con.prepareStatement("select * from quiz");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		out.println(rs.getString("question")+rs.getString("option1")+rs.getString("option2")+rs.getString("option3")+rs.getString("option4")+rs.getString("answer"));
	}
	%>

<a href="index.html">go back<br></br></a>
</body>
</html>