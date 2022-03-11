package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	public StudentDto getStudentData(Integer studentId) {
		Optional<Student> response = studentRepository.findById(studentId);
		if (!response.isPresent()) {
			throw new RuntimeException("Data not exists");
		}
		
		StudentDto dto = new StudentDto();
		dto.setEmail(response.get().getEmail());
		dto.setMobileNumber(response.get().getMobileNumber());
		dto.setStudentName(response.get().getStudentName());
		return dto;
	}

	@Override
	public List<Student> getAllStudentData() {
		List<Student> response = studentRepository.findAll();
		if (response == null || response.isEmpty()) {
			throw new RuntimeException("data is empty");
		}
		return response;
	}

	@Override
	public String saveStudentData(Student student) {
		Student response = studentRepository.save(student);
		if (response == null) {
			return "Data not saved";
		}
		return "Data saved successfully";
	}

	@Override
	public List<Student> getDetailsByName(String studentName) {
		List<Student> response = studentRepository.findByStudentName(studentName);
		if (response == null || response.isEmpty()) {
			throw new RuntimeException("data is empty");
		}
		return response;
	}

	@Override
	public Student loginStudent(String loginId, String password) {

		Optional<Student> response = studentRepository.findByLoginIdAndPassword(loginId, password);
		if (!response.isPresent()) {
			throw new RuntimeException("Data not exists");
		}
		return response.get();
	}
}
