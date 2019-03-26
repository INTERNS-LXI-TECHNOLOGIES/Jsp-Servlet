package com.erp.sis.smartinformationsystem.domain;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long studentId;
	
	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	@Column(nullable=false,length=25)
	private String name;
	
	@Column(nullable=false,length=20)
	private Long contact;

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getContact() {
		return contact;
	}

	public void setContact(Long contact) {
		this.contact = contact;
	}
	
	@Override
	public boolean equals (Object o) {
		if(this == o)
		{
			return true;
		}
		if(o == null || getClass()!=o.getClass())
		{
			return false;
		}
	Student student=(Student) o;
	if(student.getStudentId() == null|| getStudentId() == null)
	{
		return false;
	}
	
return Objects.equals(getStudentId(),student.getStudentId());
	}

@Override
     public int hashCode() {
    return Objects.hashCode(getStudentId());
}

@Override
public String toString() {
    return "Student{" +
        ",studentid=" + getStudentId() + " "+
        ",name='" + getName() + " " +
         ", contact=" + getContact() + " "+
        "}";
}
}
		

	
