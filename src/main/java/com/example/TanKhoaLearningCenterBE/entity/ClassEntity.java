package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "classes")
public class ClassEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "classId")
    private UUID classId;

    @Column(name = "className", nullable = false, unique = true)
    private String className;

    @Column(name = "description")
    private String description;

    @ManyToOne(cascade =  CascadeType.ALL)
    @JoinColumn(name = "courseId")
    private CourseEntity courseIds;
}
