package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "classes")
public class ClassEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "classId")
    private UUID classId;

    @Column(name = "className", nullable = false, unique = true)
    private String className;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "courseId")
    private CourseEntity courseIds;
}
