package com.example.projectbackend.service;

import com.example.projectbackend.exception.ApiException;
import com.example.projectbackend.model.Teacher;
import com.example.projectbackend.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    public List<Teacher> getTeacher(){
        return teacherRepository.findAll();
    }

    public void setTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id ,Teacher teacher) {
        Teacher oldTeacher= teacherRepository.getById(id);
        oldTeacher.setCourse(teacher.getCourse());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSchool(teacher.getSchool());
        oldTeacher.setClassLeader(teacher.getClassLeader());
        oldTeacher.setPhoneNumber(teacher.getPhoneNumber());
        oldTeacher.setAge(teacher.getAge());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id) {
        Teacher myTeacher=teacherRepository.getById(id);
        teacherRepository.delete(myTeacher);
    }

    public Teacher getTeacherById(Integer id) {
        Teacher teacher= teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;

    }

    public Teacher getTeacherByEmail(String email) {
        Teacher teacher= teacherRepository.findTeacherByEmail(email);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;

    }

    public Teacher getTeacherByPhoneNumber(String phoneNumber) {
        Teacher teacher= teacherRepository.findTeacherByPhoneNumber(phoneNumber);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;

    }

    public List<Teacher> getTeacherBySchool(String school) {
        List <Teacher> teacher= teacherRepository.findTeacherBySchool(school);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;
    }

    public List<Teacher> getTeacherByCourse(String course) {
        List <Teacher> teacher= teacherRepository.findTeacherByCourse(course);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;

    }

    public List<Teacher> getTeacherByGreaterAge(Integer age) {
        List <Teacher> teacher= teacherRepository.findByAgeGreaterThan(age);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;

    }

    public List<Teacher> getTeacherByLessAge(Integer age) {
        List <Teacher> teacher= teacherRepository.findByAgeLessThan(age);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;
    }

    public Teacher getTeacherByClassLeader(String classLeader) {
        Teacher teacher=teacherRepository.findTeacherByClassLeader(classLeader);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;
    }

    public List<Teacher> getTeacherByRole(String role) {
        List <Teacher> teacher= teacherRepository.findTeacherByRole(role);
        if(teacher==null){
            throw new ApiException("Wrong user ID!");
        }
        return teacher;
    }
}
