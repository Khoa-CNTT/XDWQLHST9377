package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "enrollment")
public class EnrollmentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enrollmentId")
    private UUID enrollmentId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private List<StudentEntity> studentIds;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId")
    private List<ClassEntity> classIds;

    @Column(name = "createdAt")
    private Timestamp createdAt;
}
