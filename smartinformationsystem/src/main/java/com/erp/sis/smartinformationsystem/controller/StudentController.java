package com.erp.sis.smartinformationsystem.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.erp.sis.smartinformationsystem.Service.StudentService;
import com.erp.sis.smartinformationsystem.domain.Student;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@PostMapping("/api/new")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) throws URISyntaxException {
		log.debug("Rest POST request to create student: {}",student);
		Student result = studentService.createStudent(student);
		return ResponseEntity.created(new URI("/api/new/"+result.getStudentId()))
				.header("student-created", result.toString())
				.body(result);
	}
	
	@GetMapping("/api/get/{studentId}")
	public ResponseEntity<Student> readStudent(@PathVariable Long studentId) {
		log.debug("REST request to GET Student : {}", studentId);
		Optional<Student> result = studentService.getStudent(studentId);
		return ResponseEntity.of(result);
	}
	
	@GetMapping("/api/get")
	public ResponseEntity<List<Student>> readAllStudents() {
		log.debug("REST request to GET all Contacts");
		List<Student> result = studentService.getAllStudents();
		return ResponseEntity.ok()
				.body(result);
	}
	
	@PutMapping("/api/update")
	public ResponseEntity<Student> updateContact(@RequestBody Student student) throws URISyntaxException {
		log.debug("REST PUT request to update Student : {}", student);
		if(student.getStudentId() != null)
		{
			Student result = studentService.updateStudent(student);
			return ResponseEntity.ok()
		            .header("student-updated", result.toString())
		            .body(result);
		}
		return ResponseEntity.badRequest()
				.body(null);
	}
	
	@DeleteMapping("/api/delete/{studentId}")
	public ResponseEntity<Void> deleteStudent(@PathVariable Long studentId) {
		log.debug("REST request to delete Student : {}", studentId);
		studentService.deleteStudent(studentId);
		return ResponseEntity.ok()
		.header("student-deleted", studentId.toString())
		.build();
	}
	
}
	
	
	

