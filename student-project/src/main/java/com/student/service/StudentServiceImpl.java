package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.student.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	public Student getStudentData() {

		Student student = new Student();
		student.setStudentId(1);
		student.setStudentName("XYZ");
		student.setEmail("sdfg@gmail.com");
		student.setMobileNumber("1234567890");
		student.setLoginId("123123");
		student.setPassword("12345678");

		return student;
	}

	@Override
	public List<Student> getAllStudentData() {

		List<Student> students = new ArrayList<>();

		Student student = new Student();
		student.setStudentId(2);
		student.setStudentName("ABC");
		student.setEmail("shsg@gmail.com");
		student.setMobileNumber("1234567890");
		student.setLoginId("12312378");
		student.setPassword("12345678");

		students.add(getStudentData());
		students.add(student);
		students.add(getStudentData());

		return students;
	}

}