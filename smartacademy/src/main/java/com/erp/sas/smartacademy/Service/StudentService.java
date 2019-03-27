package com.erp.sas.smartacademy.Service;

import java.util.List;
import java.util.Optional;

import com.erp.sas.smartacademy.domain.Student;


public interface StudentService {
	Student createStudent(Student student);
	Optional<Student> getStudent(Long userId);
	List<Student> getAllStudent();
	Student updateStudent(Student student);
	void deleteStudent(Long userId);
	
}
