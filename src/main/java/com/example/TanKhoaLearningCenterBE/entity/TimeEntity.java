package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.UUID;

@Entity
@Data
@Table(name = "times")
public class TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeId")
    private UUID timeId;

    @Column(name = "timeStart")
    private LocalTime timeStart;

    @Column(name = "timeEnd")
    private LocalTime timeEnd;
}
