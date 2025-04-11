package com.example.TanKhoaLearningCenterBE.dto;

import com.example.TanKhoaLearningCenterBE.entity.StudentEntity;
import lombok.Data;

import java.util.UUID;

@Data
public class StudentDTO {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;

    public StudentDTO(StudentEntity student){
        this.id = student.getStudentId();
        this.name = student.getStdName();
        this.phoneNumber = student.getStdPhoneNumber();
        this.email = student.getStdEmail();
    }
}
