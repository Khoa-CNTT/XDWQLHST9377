package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "attendance")
public class AttendanceEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "attendanceId")
    private UUID attendId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private StudentEntity studentIds;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId")
    private ClassEntity classIds;
}
