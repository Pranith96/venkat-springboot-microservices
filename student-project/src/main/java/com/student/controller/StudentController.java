package com.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@GetMapping("/get/student")
	public Student getStudentDetails() {
		Student response = studentService.getStudentData();
		return response;
	}

	@GetMapping("/get/all/student")
	public List<Student> getAllStudentDetails() {
		List<Student> response = studentService.getAllStudentData();
		return response;
	}
}