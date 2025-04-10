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
    @Column(name = "timeTableId")
    private UUID timeTableId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "dayId")
    private DayEntity dayIds;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "timeId")
    private TimeEntity timeIds;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "classId")
    private ClassEntity classIds;
}
