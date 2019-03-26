package com.erp.sis.smartinformationsystem.Service;

import java.util.List;
import java.util.Optional;

import com.erp.sis.smartinformationsystem.domain.Student;

public interface StudentService {
	
	Student createStudent(Student student);
	
	Optional<Student> getStudent(Long studentId); 
	
	List<Student> getAllStudents();
	
	Student updateStudent(Student student);
	
	void deleteStudent(Long studentId);
}