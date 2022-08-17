package com.example.day13injavacamp.HomeWork.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class ApiResponse {
    private String message;
    private Integer status;
}