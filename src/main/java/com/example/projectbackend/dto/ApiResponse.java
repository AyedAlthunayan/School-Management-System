package com.example.projectbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ApiResponse {
    private String message;
    private final Integer status;
}
