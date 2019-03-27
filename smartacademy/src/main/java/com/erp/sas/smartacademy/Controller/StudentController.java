package com.erp.sas.smartacademy.Controller;


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

import com.erp.sas.smartacademy.Service.StudentService;
import com.erp.sas.smartacademy.domain.Student;

@RestController
public class StudentController
{
	@Autowired
	StudentService studentService;
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	/**
	*@param student 
	*@return Student
	*@throws URISyntaxException
	*/
	
	@PostMapping("/api/new")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) throws URISyntaxException 
	{
		log.debug("Rest POST request to create contact: {}",student);
		Student result=studentService.createStudent(student);
		return ResponseEntity.created(new URI("/api/new/"+result.getUserId()))
		.header("X-Contact created",result.toString())
		.body(result);
	}
	
	/**
	 * @param userId
	 * @return Student
	 */
	@GetMapping("/api/get/{userId}")
	public ResponseEntity<Student> readStudent(@PathVariable Long userId)
	{
		log.debug("Rest request to get Student: {}",userId);
		Optional<Student> result = studentService.getStudent(userId);
		return ResponseEntity.of(result);
	}
	
	
	/**
	 * Used to map GET request for the list of all student in the database.
	 * 
	 * @return ResponseEntity<List<Student>> embedded with list of all of the student in database.
	 */
	
	@GetMapping("/api/get")
	public ResponseEntity<List<Student>> readAllStudent() {
		log.debug("REST request to GET all Students");
		List<Student> result = studentService.getAllStudent();
		return ResponseEntity.ok()
				.body(result);
	}
	
	
	/**
	 * Used to map PUT requests for editing a particular student
	 * 
	 * @param student, The student to be updated, assumes that the object contains updated values.
	 * @return ResponseEntity<Student> embedded with the updated student.
	 * @throws URISyntaxException possible when creating a new URI.
	 */
	
	@PutMapping("/api/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student student) throws URISyntaxException {
		log.debug("REST PUT request to update Contact : {}",student);
		if(student.getUserId() != null)
		{
			Student result = studentService.updateStudent(student);
			return ResponseEntity.ok()
		            .header("X-student-updated", result.toString())
		            .body(result);
		}
		return ResponseEntity.badRequest()
				.body(null);
	}
	
	/** 
	 * Used to map DELETE requests, for deleting a student entry from the database.
	 * 
	 * @param id, The id attribute of the contact intended to be deleted. Passed as a path variable.
	 * @return ResponseEntity<Void>  which wraps nothing. Howbeit, the required headers to show the request was successful is added.
	 */
	@DeleteMapping("/api/delete/{userId}")
	public ResponseEntity<Void> deleteContact(@PathVariable Long userId) {
		log.debug("REST request to delete Contact : {}", userId);
		studentService.deleteStudent(userId);
		return ResponseEntity.ok()
		.header("X-student-deleted", userId.toString())
		.build();
	}
}
