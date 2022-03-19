package com.student.service;

import java.util.List;

import com.student.dto.StudentDto;
import com.student.entity.Student;

public interface StudentService {

	StudentDto getStudentData(Integer studentId);

	List<Student> getAllStudentData();

	String saveStudentData(Student student);

	List<Student> getDetailsByName(String studentName);

	Student loginStudent(String loginId, String password);

	StudentDto getStudentDataByloginId(String loginId);

	String deleteStudentData(Integer studentId);

	String updateStudentData(Student student);

	String updateStudentName(String studentName, Integer studentId);

}
