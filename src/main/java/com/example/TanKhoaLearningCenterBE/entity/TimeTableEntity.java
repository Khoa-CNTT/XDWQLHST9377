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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "dayId")
    private List<DayEntity> dayId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeId")
    private List<TimeEntity> timeId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId")
    private List<ClassEntity> classId;
}
