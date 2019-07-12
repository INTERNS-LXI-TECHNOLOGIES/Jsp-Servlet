package com.lxisoft.camp;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.*;
public class DbConnection
{
	Connection con;
	PreparedStatement ps;
	public DbConnection()
	{
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/quizdb","root","root");
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	}
	
	public int insert(Question q)
	{
		int status=0;
		try
		{
			String insertQuery="insert into question(questionNo,question,option1,option2,option3,option4,answer) values(?,?,?,?,?,?,?)";
			ps=con.prepareStatement(insertQuery);
			ps.setInt(1,q.getQuestionNo());
			ps.setString(2,q.getQuestion());
			ps.setString(3,q.getOption1());
			ps.setString(4,q.getOption2());
			ps.setString(5,q.getOption3());
			ps.setString(6,q.getOption4());
			ps.setString(7,q.getAnswer());
			status=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return status;
	}
	
	public ArrayList<Question> selectFromDb()
	{
		ArrayList<Question> questionList=new ArrayList<Question>();
		ResultSet rs;
		Question q=null;
		try
		{
			String selectQuery="select * from question";
			ps=con.prepareStatement(selectQuery);
			
			rs=ps.executeQuery();
			while(rs.next())
			{
				q=new Question();
				int questionNo=rs.getInt("questionNo");
				String question=rs.getString("question");
				String option1=rs.getString("option1");
				String option2=rs.getString("option2");
				String option3=rs.getString("option3");
				String option4=rs.getString("option4");
				String answer=rs.getString("answer");
				
				q.setQuestionNo(questionNo);
				q.setQuestion(question);
				q.setOption1(option1);
				q.setOption2(option2);
				q.setOption3(option3);
				q.setOption4(option4);
				q.setAnswer(answer);
				questionList.add(q);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return questionList;
	}
}