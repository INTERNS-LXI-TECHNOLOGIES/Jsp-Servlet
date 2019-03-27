package com.erp.sas.smartacademy.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userId;

	@Column(nullable=false, length=20) 
	private String name;
	  
	@Column(nullable=false, length=20)
	private String contact;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((userId == null) ? 0 : userId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student student = (Student) obj;
		if (contact == null) {
			if (student.contact != null)
				return false;
		} else if (!contact.equals(student.contact))
			return false;
		if (name == null) {
			if (student.name != null)
				return false;
		} else if (!name.equals(student.name))
			return false;
		if (userId == null) {
			if (student.userId != null)
				return false;
		} else if (!userId.equals(student.userId))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Student [userId=" + userId + ", name=" + name + ", contact=" + contact + "]";
	}
	
	
}
