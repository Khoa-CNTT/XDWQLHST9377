package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "times")
public class TimeEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "timeId")
    private UUID timeId;

    @Column(name = "timeStart", nullable = false)
    private LocalTime timeStart;

    @Column(name = "timeEnd", nullable = false)
    private LocalTime timeEnd;
}
