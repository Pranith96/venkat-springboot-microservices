package com.student.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findByStudentName(String studentName);

	Optional<Student> findByLoginIdAndPassword(String loginId, String password);

	// JPA query
	// Optional<Student> findByLoginId(String loginId);

	// jpql
	// @Query("select s from Student s where s.loginId = :loginId")
	// Optional<Student> getDetailsByLoginId(String loginId);

	// native query = sql
	@Query(value = "select * from student_table where login_id = :loginId", nativeQuery = true)
	Optional<Student> getDetailsByLoginId(String loginId);

	@Modifying
	@Query("update Student s set s.studentName=:studentName where s.studentId=:studentId")
	void updateStudentNameById(String studentName, Integer studentId);

}
