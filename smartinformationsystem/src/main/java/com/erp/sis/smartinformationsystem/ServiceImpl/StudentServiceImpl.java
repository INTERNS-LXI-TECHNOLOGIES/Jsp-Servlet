package com.erp.sis.smartinformationsystem.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.sis.smartinformationsystem.Repository.StudentRepository;
import com.erp.sis.smartinformationsystem.Service.StudentService;
import com.erp.sis.smartinformationsystem.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
StudentRepository studentRepository;

	@Override
	public Student createStudent(Student student) {
		return studentRepository.save(student);
		
	}

	@Override
	public Optional<Student> getStudent(Long studentId) {
		return studentRepository.findById(studentId);
	}

	@Override
	public List<Student> getAllStudents() {
		return studentRepository.findAll();
	}

	@Override
	
	public Student updateStudent(Student student) {
		return studentRepository.save(student);
	}
	

	@Override
	public void deleteStudent(Long studentId) {
		studentRepository.delete(studentRepository.getOne(studentId));
	}


	

}
