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
		//out.print("bjgn"+q.print());
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
%>
<table border="1" width="80px" class=table-borderd text-center" style="border: 30px solid black">
<tr>
	<td> </td>
	<td>questions</td>
	<td>Option1</td>
	<td>Option2</td>
	<td>Option3</td>
	<td>Option4</td>
	<td>Answer</td>
</tr>
	<tr>
		<td>Q1</td>
		<td><%=quiz.q1.question%></td>
		<td><%=quiz.q1.option1%></td>
		<td><%=quiz.q1.option2%></td>
		<td><%=quiz.q1.option3%></td>
		<td><%=quiz.q1.option4%></td>
		<td><%=quiz.q1.answer%></td>
		
	
	</tr>
	<tr>
		<td>Q2</td>
		<td><%=quiz.q2.question%></td>
		<td><%=quiz.q2.option1%></td>
		<td><%=quiz.q2.option2%></td>
		<td><%=quiz.q2.option3%></td>
		<td><%=quiz.q2.option4%></td>
		<td><%=quiz.q2.answer%></td>
		

	</tr>
	<tr>
		<td>Q3</td>
		<td><%=quiz.q3.question%></td>
		<td><%=quiz.q3.option1%></td>
		<td><%=quiz.q3.option2%></td>
		<td><%=quiz.q3.option3%></td>
		<td><%=quiz.q3.option4%></td>
		<td><%=quiz.q3.answer%></td>
		
	
	</tr>
	<tr>
		<td>Q4</td>
		<td><%=quiz.q4.question%></td>
		<td><%=quiz.q4.option1%></td>
		<td><%=quiz.q4.option2%></td>
		<td><%=quiz.q4.option3%></td>
		<td><%=quiz.q4.option4%></td>
		<td><%=quiz.q4.answer%></td>
		
	
	</tr>
	<tr>
		<td>Q5</td>
		<td><%=quiz.q5.question%></td>
		<td><%=quiz.q5.option1%></td>
		<td><%=quiz.q5.option2%></td>
		<td><%=quiz.q5.option3%></td>
		<td><%=quiz.q5.option4%></td>
		<td><%=quiz.q5.answer%></td>
		
	
	</tr>

</table>
<% Class.forName("com.mysql.jdbc.Driver");
Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Quizdb","root","akhil1234");

	PreparedStatement ps= con.prepareStatement("insert into questions(question_no,qname,Option1,Option2,Option3,Option4,Answer) values(1,'"+quiz.q1.question+"','"+quiz.q1.option1+"','"+quiz.q1.option2+"','"+quiz.q1.option3+"','"+quiz.q1.option4+"','"+quiz.q1.answer+"');");

	 ps=con.prepareStatement("select * from questions");
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		out.println(rs.getString("question_no")+
					rs.getString("qname")+
					rs.getString("Option1")+
					rs.getString("Option2")+
					rs.getString("Option3")+
					rs.getString("Option4")+
					rs.getString("Answer"));

	}
	%>

<a href="index.html"><tr><br>go back</br></tr></a>
</body>
</html>