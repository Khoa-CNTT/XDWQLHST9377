package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name = "enrollment")
public class EnrollmentEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "enrollmentId")
    private UUID enrollmentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private StudentEntity studentIds;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId")
    private ClassEntity classIds;
}
