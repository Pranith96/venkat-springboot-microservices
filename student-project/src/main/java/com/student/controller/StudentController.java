package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/save")
	public ResponseEntity<String> createStudent(@RequestBody Student student) {
		String response = studentService.saveStudentData(student);
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}

	@GetMapping("/get/student/{studentId}")
	public ResponseEntity<StudentDto> getStudentDetails(@PathVariable("studentId") Integer studentId) {
		StudentDto response = studentService.getStudentData(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/all/student")
	public ResponseEntity<List<Student>> getAllStudentDetails() {
		List<Student> response = studentService.getAllStudentData();
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/details/{name}")
	public ResponseEntity<List<Student>> getAllStudentDetailsByName(@PathVariable("name") String studentName) {
		List<Student> response = studentService.getDetailsByName(studentName);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/login/{loginId}/{password}")
	public ResponseEntity<Student> loginStudent(@PathVariable("loginId") String loginId,
			@PathVariable("password") String password) {
		Student response = studentService.loginStudent(loginId, password);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

}
