package com.student.service;

import java.util.List;

import com.student.entity.Student;

public interface StudentService {

	Student getStudentData();

	List<Student> getAllStudentData();

}