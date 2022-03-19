package com.student.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class StudentExceptionHandler {

	private final String EXCEPTION_CODE = "1234_NOTFOUND";

	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleStudentNotFoubdException(StudentNotFoundException ex,
			WebRequest request) {
		ExceptionResponse response = new ExceptionResponse();
		response.setCode(EXCEPTION_CODE);
		response.setDetails("Details Not Found");
		response.setMessage(ex.getLocalizedMessage());
		response.setDateTime(LocalDateTime.now());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
	}
}