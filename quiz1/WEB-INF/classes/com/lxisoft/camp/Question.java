package com.lxisoft.camp;
public class Question
{
	public String question;
	public int qno;
	public String option1;
	public String option2;
	public String option3;
	public String option4;
	public String answer;

	public String print()
	{
		return "Hellow..."+question+"\n"+option1+"\n"+option2+"\n"+option3+"\n"+option4+"\n\t answer : "+answer;
	}
}