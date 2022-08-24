package com.example.projectbackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.projectbackend.model.Teacher;

import java.util.List;


@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    Teacher findTeacherById(Integer id);
    Teacher findTeacherByEmail(String email);
    Teacher findTeacherByPhoneNumber(String phoneNumber);
    List <Teacher> findTeacherBySchool(String school);
    List <Teacher> findTeacherByCourse(String course);
    List<Teacher> findByAgeGreaterThan(Integer age);
    List<Teacher> findByAgeLessThan(Integer age);
    Teacher findTeacherByClassLeader(String classLeader);
    List<Teacher>findTeacherByRole(String role);


}
