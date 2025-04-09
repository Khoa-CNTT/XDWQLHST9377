package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "times")
public class TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "timeId")
    private UUID timeId;

    @Column(name = "timeStart", nullable = false)
    private LocalTime timeStart;

    @Column(name = "timeEnd", nullable = false)
    private LocalTime timeEnd;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "time_id")
    private List<TimeTableEntity> timeIds;
}
