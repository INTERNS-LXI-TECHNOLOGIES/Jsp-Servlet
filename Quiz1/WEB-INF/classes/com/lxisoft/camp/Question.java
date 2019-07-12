package com.lxisoft.camp;
public class Question{

	public String question;
	public String option1;
	public String option2;
	public String option3;
	public String option4;
	public String answer;

	public String print(){
		return "question: "+question+"</br>option1: "+option1+"</br>option2: "+option2+"</br>option3: "+option3+"</br>option4: "+option4;
	}
}