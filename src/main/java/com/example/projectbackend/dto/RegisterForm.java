package com.example.projectbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data @AllArgsConstructor
public class RegisterForm {
//    @NotEmpty(message = "username can not ot be empty")
    private String userName;

//    @NotEmpty(message = "password can not ot be empty")
    private String password;


//    @NotEmpty(message = "role can not be empty")
//    @Pattern(regexp = "(TEACHER|STUDENT)")
    private String role;

//    @NotEmpty(message = "name can not ot be empty")
    private String name;


//    @NotEmpty(message = "Email can not ot be empty")
//    @Email(message = "incorrect email")
//    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;


//    @NotEmpty(message = "Phone number can not be empty")
//    @Pattern(regexp = "/^[a-z]{0,10}$/")
    private String phoneNumber;


//    @NotEmpty(message = "class leader can not ot be empty")
    private String classLeader;


//    @NotEmpty(message = "classes can not be empty")
    private String course;


//    @NotEmpty(message = "school can not be empty")
    private String school;


//    @NotNull(message = "age can not be empty")
    private Integer age;


//    @NotEmpty(message = "level can not be empty")
    private String level;





}
