package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.student.dto.LoginDto;
import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.service.StudentService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping("/save")
	 @ApiOperation(value = "Student account Creation API",
     notes = "Please provide all the info for Student account creation",
     response = Student.class)
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
	@ApiOperation(value = "Get Student Details API",
    notes = "Please provide Details to get student account",
    response = Student.class)
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

	@GetMapping("/get")
	public ResponseEntity<StudentDto> getStudentDetailsById(@RequestParam("studentId") Integer studentId) {
		StudentDto response = studentService.getStudentData(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@GetMapping("/get/data")
	public ResponseEntity<StudentDto> getStudentData(
			@RequestParam(value = "studentId", required = false) Integer studentId,
			@RequestParam(value = "loginId", required = false) String loginId) {
		StudentDto response = null;
		if (studentId != null) {
			response = studentService.getStudentData(studentId);
		} else if (loginId != null) {
			response = studentService.getStudentDataByloginId(loginId);
		}
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@DeleteMapping("/delete/{studentId}")
	public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Integer studentId) {
		String response = studentService.deleteStudentData(studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PostMapping("/login/details")
	public ResponseEntity<Student> studentLogin(@RequestBody LoginDto loginDto) {
		Student response = studentService.loginStudent(loginDto.getLoginId(), loginDto.getPassword());
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update/details")
	public ResponseEntity<String> updateStudent(@RequestBody Student student) {
		String response = studentService.updateStudentData(student);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}

	@PutMapping("/update/{name}/{studentId}")
	public ResponseEntity<String> updateStudentName(@PathVariable("name") String studentName,
			@PathVariable("studentId") Integer studentId) {
		String response = studentService.updateStudentName(studentName,studentId);
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
}
