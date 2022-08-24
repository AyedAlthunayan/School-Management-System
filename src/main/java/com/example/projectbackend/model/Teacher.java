package com.example.projectbackend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data @AllArgsConstructor
@NoArgsConstructor @Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @NotEmpty(message = "name can not ot be empty")
    private String name;


    @NotEmpty(message = "Email can not ot be empty")
    @Email (message = "incorrect email")
    @Column(columnDefinition = "varchar(30) unique not null")
    private String email;


    @NotEmpty(message = "Phone number can not be empty")
    private String phoneNumber;


    @NotEmpty(message = "class leader can not ot be empty")
    private String classLeader;


    @NotEmpty(message = "classes can not be empty")
    private String course;


    @NotEmpty(message = "school can not be empty")
    private String school;


    @NotNull(message = "age can not be empty")
    private Integer age;


    @NotEmpty(message = "role can not be empty")
    @Pattern(regexp = "(TEACHER|STUDENT)")
    private String role;

    @NotNull
    private Integer userId;


}
