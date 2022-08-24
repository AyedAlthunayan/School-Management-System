package com.example.projectbackend.controller;

import com.example.projectbackend.dto.ApiResponse;
import com.example.projectbackend.model.Student;
import com.example.projectbackend.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity getStudent(){
        return ResponseEntity.status(200).body(studentService.getStudent());
    }
    @PostMapping
    public ResponseEntity setStudent(@RequestBody @Valid Student student){
        studentService.setStudent(student);
        return ResponseEntity.status(201).body(new ApiResponse("Student saved",200));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateStudent(@RequestBody @Valid Student student,@PathVariable Integer id){
        studentService.updateStudent(id,student);
        return ResponseEntity.status(201).body(new ApiResponse("Student updated",200));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable @Valid Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(201).body(new ApiResponse("Student deleted",200));

    }
    @GetMapping("/id")
    public ResponseEntity<Student> getStudentById(@RequestParam  Integer id){
        Student student=studentService.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/email")
    public ResponseEntity<Student> getStudentByEmail(@RequestParam String email){
        Student student=studentService.getStudentByEmail(email);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/phone")
    public ResponseEntity<Student> getStudentByPhoneNumber(@RequestParam  String phoneNumber){
        Student student=studentService.getStudentByPhoneNumber(phoneNumber);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/level")
    public ResponseEntity<List> getStudentByLevel(@RequestParam  String level){
       List <Student> student=studentService.getStudentByLevel(level);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/school")
    public ResponseEntity<List> getStudentBySchool(@RequestParam  String school){
        List <Student> student=studentService.getStudentBySchool(school);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/age/greater")
    public ResponseEntity<List> getStudentByGreaterAge(@RequestParam  Integer age){
        List <Student> student=studentService.getStudentByGreaterAge(age);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/age/less")
    public ResponseEntity<List> getStudentByLessAge(@RequestParam  Integer age){
        List <Student> student=studentService.getStudentByLessAge(age);
        return ResponseEntity.status(200).body(student);
    }
    @GetMapping("/role")
    public ResponseEntity<List> getStudentByRole(@RequestParam  String role){
        List <Student> student=studentService.getStudentByRole(role);
        return ResponseEntity.status(200).body(student);
    }


}
