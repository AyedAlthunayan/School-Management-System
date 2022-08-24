package com.example.projectbackend.controller;

import com.example.projectbackend.dto.ApiResponse;
import com.example.projectbackend.model.Teacher;
import com.example.projectbackend.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/api/v1/teacher")
@RestController
@RequiredArgsConstructor
public class teacherController {
    private final TeacherService teacherService;
    @GetMapping
    public ResponseEntity getTeacher(){
        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }
    @PostMapping
    public ResponseEntity setTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.setTeacher(teacher);
        return ResponseEntity.status(201).body(new ApiResponse("teacher added",201));
    }
    @PutMapping("/{id}")
    public ResponseEntity updateTeacher(@RequestBody @Valid Teacher teacher,@PathVariable Integer id){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(201).body(new ApiResponse("teacher updated",201));

    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteTeacher(@PathVariable @Valid Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(201).body(new ApiResponse("teacher deleted",201));

    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Teacher> getStudentById(@PathVariable @Valid Integer id){
        Teacher teacher=teacherService.getTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("/email")
    public ResponseEntity<Teacher> getStudentByEmail(@RequestBody @Valid String email){
        Teacher teacher=teacherService.getTeacherByEmail(email);
        return ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("/phone")
    public ResponseEntity<Teacher> getStudentByPhoneNumber(@RequestBody @Valid String phoneNumber){
        Teacher teacher=teacherService.getTeacherByPhoneNumber(phoneNumber);
        return ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("/school")
    public ResponseEntity<List> getTeacherBySchool(@RequestBody @Valid String school){
        List <Teacher> teachers=teacherService.getTeacherBySchool(school);
        return ResponseEntity.status(200).body(teachers);
    }
    @GetMapping("/course")
    public ResponseEntity<List> getTeacherByCourse(@RequestBody @Valid String course){
        List <Teacher> teachers=teacherService.getTeacherByCourse(course);
        return ResponseEntity.status(200).body(teachers);
    }
    @GetMapping("/age/greater")
    public ResponseEntity<List> getTeacherByGreaterAge(@RequestBody @Valid Integer age){
        List <Teacher> teachers=teacherService.getTeacherByGreaterAge(age);
        return ResponseEntity.status(200).body(teachers);
    }
    @GetMapping("/age/less")
    public ResponseEntity<List> getTeacherByLessAge(@RequestBody @Valid Integer age){
        List <Teacher> teachers=teacherService.getTeacherByLessAge(age);
        return ResponseEntity.status(200).body(teachers);
    }
    @GetMapping("/leader")
    public ResponseEntity<Teacher> getStudentByClassLeader(@RequestBody @Valid String classLeader){
        Teacher teacher=teacherService.getTeacherByClassLeader(classLeader);
        return ResponseEntity.status(200).body(teacher);
    }
    @GetMapping("/role")
    public ResponseEntity<List> getTeacherByRole(@RequestBody @Valid String role){
        List <Teacher> teachers=teacherService.getTeacherByRole(role);
        return ResponseEntity.status(200).body(teachers);
    }
}
