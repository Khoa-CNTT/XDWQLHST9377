package com.example.TanKhoaLearningCenterBE.web.rest.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
}
