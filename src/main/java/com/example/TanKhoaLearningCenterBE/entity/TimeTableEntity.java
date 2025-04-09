package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "timeTables")
public class TimeTableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @Column(name = "dayId")
    private UUID dayId;

    @Column(name = "timeId")
    private UUID timeId;

    @Column(name = "classId")
    private UUID classId;
}
