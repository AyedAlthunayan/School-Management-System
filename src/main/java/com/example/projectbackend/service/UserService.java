package com.example.projectbackend.service;

import com.example.projectbackend.dto.RegisterForm;
import com.example.projectbackend.model.*;
import com.example.projectbackend.repository.CourseRepository;
import com.example.projectbackend.repository.StudentRepository;
import com.example.projectbackend.repository.TeacherRepository;

import com.example.projectbackend.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherrepository;

    private final CourseRepository courseRepository;

    public void register(RegisterForm registerForm) {
        String hashedPassword=new BCryptPasswordEncoder().encode(registerForm.getPassword());
        registerForm.setPassword(hashedPassword);
        User myUser=new User(null,registerForm.getUserName(),registerForm.getPassword(),registerForm.getRole());
        User newUser=userRepository.save(myUser);
        Course myCourse=new Course(null,registerForm.getCourse());
        Course newCourse=courseRepository.save(myCourse);

        if (registerForm.getRole().equals("TEACHER")){
            Teacher teacher=new Teacher(null,registerForm.getName(),registerForm.getEmail(),registerForm.getPhoneNumber(),
                    registerForm.getClassLeader(),registerForm.getCourse(),registerForm.getSchool(),
                    registerForm.getAge(),registerForm.getRole(),newUser.getId());
            teacherrepository.save(teacher);

        }else {
            Student student=new Student
                    (null,registerForm.getName(),registerForm.getEmail(),registerForm.getPhoneNumber(),
                            registerForm.getLevel(),registerForm.getSchool(),registerForm.getAge(),
                            registerForm.getRole(),newUser.getId(),registerForm.getCourse());
            studentRepository.save(student);
        }


    }
}
