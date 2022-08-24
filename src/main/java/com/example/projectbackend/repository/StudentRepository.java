package com.example.projectbackend.repository;

import com.example.projectbackend.model.Course;
import com.example.projectbackend.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    Student findStudentById(Integer id);
    Student findStudentByEmail(String email);
    Student findStudentByPhoneNumber(String phoneNumber);
    List<Student> findStudentByLevel(String level);
    List <Student> findStudentBySchool(String school);
    List<Student> findByAgeGreaterThan(Integer age);
    List<Student> findByAgeLessThan(Integer age);
    List<Student>findStudentByRole(String role);

}
