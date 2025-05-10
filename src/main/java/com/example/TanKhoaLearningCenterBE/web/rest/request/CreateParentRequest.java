package com.example.TanKhoaLearningCenterBE.web.rest.request;

import lombok.Data;

@Data
public class CreateParentRequest {
    private String name;
    private String phoneNumber;
    private String email;
}
