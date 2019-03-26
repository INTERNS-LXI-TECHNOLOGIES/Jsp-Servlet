package com.lxisoft.orangeAlert.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(nullable = false, length = 20)
	private String name;
	
	@Column(nullable = false, length = 20)
	private String age;
	
	@Column(nullable = false, length = 20)
	private String location;
	
	@Column(nullable = false)
	private Long phoneNumber;
	
	@Column(nullable = false, length = 20)
	private String email;
	
	@Column(nullable = false, length = 20)
	private String password;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        if (user.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), user.getId());
	}
	
	@Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
	
	@Override
    public String toString() {
        return "User{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", age='" + getAge() + "'" +
			 ", location='" + getLocation() + "'" +
            ", phoneNumber=" + getPhoneNumber() +
			 ", email='" + getEmail() + "'" +
			  ", password='" + getPassword() + "'" +
            "}";
    }
}
