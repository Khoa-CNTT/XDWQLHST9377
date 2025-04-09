package com.example.TanKhoaLearningCenterBE.web.rest.old.request;

import lombok.Data;

@Data
public class CreateUserRequest {
    private String username;
    private String password;
}
