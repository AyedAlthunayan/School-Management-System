package com.example.projectbackend.controller;

import com.example.projectbackend.dto.ApiResponse;
import com.example.projectbackend.dto.RegisterForm;
import com.example.projectbackend.model.User;
import com.example.projectbackend.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final UserService userService;
    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterForm registerForm){
        userService.register(registerForm);
        return ResponseEntity.status(201).body(new ApiResponse("register completed",201));
    }
    @PostMapping("/login")
    public ResponseEntity login(){
        return ResponseEntity.status(200).body("Welcome back");

    }
}
