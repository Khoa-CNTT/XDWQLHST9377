package com.example.TanKhoaLearningCenterBE.web.rest.request;

import lombok.Data;

@Data
public class CreateStudentRequest {
    private String name;
    private String phoneNumber;
    private String email;
}
