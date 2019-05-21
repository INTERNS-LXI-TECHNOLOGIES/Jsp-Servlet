package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	
		Laptop l = new Laptop();
		l.setLid("1");
		l.setLname("hp");
		
		Student s = new Student();
		s.setId("101");
		s.setName("navin");
		s.setMark("50");
		s.getLaptop().add(l);
	}

}
