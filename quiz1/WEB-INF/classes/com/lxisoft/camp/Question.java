package com.lxisoft.camp;
public class Question
{
	public String question;
	public String option1;
	public String option2;
	public String option3;
	public String option4;
	public String answer;
	public String printDetails()
	{
		return question+"</br>"+option1+"</br>"+option2+"</br>"+option3+"</br>"+option4+"</br>"+answer;
	}
}