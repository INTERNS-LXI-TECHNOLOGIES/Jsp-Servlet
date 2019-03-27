package com.erp.sas.smartacademy.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.erp.sas.smartacademy.Repository.StudentRepository;
import com.erp.sas.smartacademy.Service.StudentService;
import com.erp.sas.smartacademy.domain.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public Optional<Student> getStudent(Long userId) {
		// TODO Auto-generated method stub
		return studentRepository.findById(userId);
	}

	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student updateStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long userId) {
		// TODO Auto-generated method stub
		studentRepository.delete(studentRepository.getOne(userId));
	}

}
