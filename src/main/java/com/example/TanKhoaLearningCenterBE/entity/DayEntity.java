package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "days")
public class DayEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dayId")
    private UUID dayId;

    @Column(name = "day", nullable = false, unique = true)
    private String day;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "day_id")
    private List<TimeTableEntity> dayIds;
}
