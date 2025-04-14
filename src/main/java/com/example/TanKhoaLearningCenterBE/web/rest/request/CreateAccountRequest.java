package com.example.TanKhoaLearningCenterBE.web.rest.request;

import lombok.Data;

@Data
public class CreateAccountRequest {
    private String username;
    private String password;
}
