package com.example.TanKhoaLearningCenterBE.dto;

import java.util.UUID;

public class StudentDTO {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;
    private UUID parentId;

    public StudentDTO(UUID id, String name, String phoneNumber, String email, UUID parentId) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.parentId = parentId;
    }
}
