<%@ page import ="com.lxisoft.camp.Question"%>
<%@ page import ="com.lxisoft.camp.Quiz"%>
<%@ page import ="java.sql.*"%>
import
<html>
<head>
	<title> Quiz </title>
</head>
<body>
<%




String question=request.getParameter("question");
String option1=request.getParameter("option1");
String option2=request.getParameter("option2");
String option3=request.getParameter("option3");
String option4=request.getParameter("option4");
String answer=request.getParameter("answer");
Quiz q;
if(session.getAttribute("quiz")==null){
	q=new Quiz();
	session.setAttribute("quiz",q);
}
else{
	q=(Quiz)session.getAttribute("quiz");
	if(q.q1==null)
	{
		q.q1=new Question();
		q.q1.question= question;
		q.q1.option1=option1;
		q.q1.option2=option2;
		q.q1.option3=option3;
		q.q1.option4=option4;
		q.q1.answer=answer;
		
	}
	else if(q.q2==null){
		q.q2=new Question();
		q.q2.question= question;
		q.q2.option1=option1;
		q.q2.option2=option2;
		q.q2.option3=option3;
		q.q2.option4=option4;
		q.q2.answer=answer;
	}
	else if(q.q3==null){
		q.q3=new Question();
		q.q3.question= question;
		q.q3.option1=option1;
		q.q3.option2=option2;
		q.q3.option3=option3;
		q.q3.option4=option4;
		q.q3.answer=answer;
	}
	else if(q.q4==null){
		q.q4=new Question();
		q.q4.question= question;
		q.q4.option1=option1;
		q.q4.option2=option2;
		q.q4.option3=option3;
		q.q4.option4=option4;
		q.q4.answer=answer;
	}
	else
	{
	out.println("Maximim Question Exceed");
	}
}

//out.println(q.print());       
%>
<h1>Quiz</h1>
<table border="1" width="60px" class="table-bordered text-center" style="border: 5px solid Red">
				
                
<tbody>
					<tr>
						<td>  </td>
						<td>question</td>
						<td>option1</td>
						<td>option2</td>
						<td>option3</td>
						<td>option4</td>
						<td>answer</td>
					</tr>
                    <tr>
                        <td>Q1</td>
                        <td><%=q.q1.question%></td>
                        <td><%=q.q1.option1%></td>
                        <td><%=q.q1.option2%></td>
                        <td><%=q.q1.option3%></td>
                        <td><%=q.q1.option4%></td>
                        <td><%=q.q1.answer%></td>
                    </tr>
                    <tr>
                        <td>Q2</td>
                        <td><%=q.q2.question%></td>
                        <td><%=q.q2.option1%></td>
                        <td><%=q.q2.option2%></td>
                        <td><%=q.q2.option3%></td>
                        <td><%=q.q2.option4%></td>
                        <td><%=q.q2.answer%></td>
                    </tr>
                    <tr>
                        <td>Q3</td>
                        <td><%=q.q3.question%></td>
                        <td><%=q.q3.option1%></td>
                        <td><%=q.q3.option2%></td>
                        <td><%=q.q3.option3%></td>
                        <td><%=q.q3.option4%></td>
                        <td><%=q.q3.answer%></td>
                    </tr>
                    <tr>
                        <td>Q4</td>
                        <td><%=q.q4.question%></td>
                        <td><%=q.q4.option1%></td>
                        <td><%=q.q4.option2%></td>
                        <td><%=q.q4.option3%></td>
                        <td><%=q.q4.option4%></td>
                        <td><%=q.q4.answer%></td>
                    </tr>
                 
</tbody>
</table>
<% 
try{
	Class.forName("com.mysql.jdbc.Driver");
	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Quiz_db","root","hrithika30");

		PreparedStatement ps=con.prepareStatement("insert into Question(Question_no,question,Option1,option2,option3,option4,answer)values (1,'"+q.q1.question+"','"+q.q1.option1+"','"+q.q1.option2+"','"+q.q1.option3+"','"+q.q1.option4+"','"+q.q1.answer+"')");
		ps.executeUpdate();

		ps=con.prepareStatement("select * from question ");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			out.println(rs.getString("question_no"));
			out.println(rs.getString("question"));
			out.println(rs.getString("Option1"));
			out.println(rs.getString("option2"));
			out.println(rs.getString("option3"));
			out.println(rs.getString("option4"));
			out.println(rs.getString("answer"));
		}
	}
	catch(Exception e){
	e.printStackTrace();
	}
	%>
<a href="index.html"><tr>go back</tr></br></br></a>

</body>
</html>