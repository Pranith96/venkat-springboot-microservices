package com.student.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "student_table")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
//@Data
public class Student {

	@Id
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer studentId;
	@Column(name = "student_name")
	private String studentName;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "email_id")
	private String email;
	@Column(name = "login_id", unique = true)
	private String loginId;
	@Column(name = "password")
	private String password;
}
