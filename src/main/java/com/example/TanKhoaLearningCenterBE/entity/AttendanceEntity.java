package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "attendance")
public class AttendanceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "attendanceId")
    private UUID atendId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private List<StudentEntity> studentID;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId")
    private List<ClassEntity> classId;
}
