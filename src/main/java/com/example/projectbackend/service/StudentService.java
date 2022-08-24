package com.example.projectbackend.service;

import com.example.projectbackend.exception.ApiException;
import com.example.projectbackend.model.Student;
import com.example.projectbackend.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public List<Student> getStudent (){
        return studentRepository.findAll();
    }
    public void setStudent(Student student) {
        studentRepository.save(student);
    }

    public void updateStudent(Integer id, Student student) {
        Student oldStudent=studentRepository.getById(id);
        oldStudent.setName(student.getName());
        oldStudent.setEmail(student.getEmail());
        oldStudent.setLevel(student.getLevel());
        oldStudent.setSchool(student.getSchool());
        oldStudent.setPhoneNumber(oldStudent.getPhoneNumber());
        oldStudent.setAge(student.getAge());
        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id) {
        Student myStudent=studentRepository.getById(id);
        studentRepository.delete(myStudent);
        }

    public Student getStudentById(Integer id) {
       Student student= studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("Wrong user ID!");
        }
        return student;
    }

    public Student getStudentByEmail(String email) {
       Student student = studentRepository.findStudentByEmail(email);
        if(student==null){
            throw new ApiException("Wrong user email!");
        }
        return student;
    }

    public Student getStudentByPhoneNumber(String phoneNumber) {
        Student student = studentRepository.findStudentByPhoneNumber(phoneNumber);
        if(student==null){
            throw new ApiException("Wrong user phone number!");
        }
        return student;
    }

    public List<Student> getStudentByLevel(String level) {
        List <Student> student = studentRepository.findStudentByLevel(level);
        if(student==null){
            throw new ApiException("Wrong user level!");
        }
        return student;
    }

    public List<Student> getStudentBySchool(String school) {
        List <Student> student = studentRepository.findStudentBySchool(school);
        if(student==null){
            throw new ApiException("Wrong user school!");
        }
        return student;
    }

    public List<Student> getStudentByGreaterAge(Integer age) {
        List <Student> student = studentRepository.findByAgeGreaterThan(age);
        if(student==null){
            throw new ApiException("Wrong user school!");
        }
        return student;
    }

    public List<Student> getStudentByLessAge(Integer age) {
        List <Student> student = studentRepository.findByAgeLessThan(age);
        if(student==null){
            throw new ApiException("Wrong user school!");
        }
        return student;
    }

    public List<Student> getStudentByRole(String role) {
        List <Student> student = studentRepository.findStudentByRole(role);
        if(student==null){
            throw new ApiException("Wrong user school!");
        }
        return student;
    }
}
