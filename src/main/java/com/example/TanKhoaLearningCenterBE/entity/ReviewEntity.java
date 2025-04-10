package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "reviews")
public class ReviewEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reviewId")
    private UUID reviewId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "teacherId")
    private TeacherEntity teacherIds;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private StudentEntity studentIds;

    @Column(name = "description")
    private String description;
}
