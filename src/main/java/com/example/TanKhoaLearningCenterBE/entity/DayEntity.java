package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "days")
public class DayEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "dayId")
    private UUID dayId;

    @Column(name = "day", nullable = false, unique = true)
    private String day;
}
