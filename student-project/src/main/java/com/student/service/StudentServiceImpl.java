package com.student.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.dto.StudentDto;
import com.student.entity.Student;
import com.student.exceptions.StudentNotFoundException;
import com.student.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	public StudentDto getStudentData(Integer studentId) {
		Optional<Student> response = studentRepository.findById(studentId);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student records not found for " + studentId);
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
			throw new StudentNotFoundException("Student Data is empty");
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
			throw new StudentNotFoundException("Student Data is empty");
		}
		return response;
	}

	@Override
	public Student loginStudent(String loginId, String password) {

		Optional<Student> response = studentRepository.findByLoginIdAndPassword(loginId, password);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student records not found for provided details");
		}
		return response.get();
	}

	@Override
	public StudentDto getStudentDataByloginId(String loginId) {
		Optional<Student> response = studentRepository.getDetailsByLoginId(loginId);
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student records not found for provided details");
		}

		StudentDto dto = new StudentDto();
		dto.setEmail(response.get().getEmail());
		dto.setMobileNumber(response.get().getMobileNumber());
		dto.setStudentName(response.get().getStudentName());
		return dto;
	}

	@Override
	public String deleteStudentData(Integer studentId) {
		Optional<Student> response = studentRepository.findById(studentId);
		if (!response.isPresent()) {
			throw new RuntimeException("Data not exists");
		}
		studentRepository.deleteById(studentId);
		return "deleted successfully";
	}

	@Transactional
	@Override
	public String updateStudentData(Student student) {
		Optional<Student> response = studentRepository.findById(student.getStudentId());
		if (!response.isPresent()) {
			throw new StudentNotFoundException("Student records not found for provided details");
		}

		if (student.getStudentName() != null && !student.getStudentName().isBlank()) {
			response.get().setStudentName(student.getStudentName());
		}
		if (student.getEmail() != null && !student.getEmail().isBlank()) {
			response.get().setEmail(student.getEmail());
		}
		if (student.getLoginId() != null && !student.getLoginId().isBlank()) {
			response.get().setLoginId(student.getLoginId());
		}
		if (student.getMobileNumber() != null && !student.getMobileNumber().isBlank()) {
			response.get().setMobileNumber(student.getMobileNumber());
		}
		if (student.getPassword() != null && !student.getPassword().isBlank()) {
			response.get().setPassword(student.getPassword());
		}
		studentRepository.save(response.get());
		return "Updated successfully";
	}

	@Transactional
	@Override
	public String updateStudentName(String studentName, Integer studentId) {
		studentRepository.updateStudentNameById(studentName, studentId);
		return "Updated name succesfully";
	}
}
