package com.example.TanKhoaLearningCenterBE.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name = "bills")
public class BillEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billId")
    private UUID billId;

    @Column(name = "billStatus")
    private Boolean billStatus;

    @Column(name = "createdAt")
    private Timestamp createdAt;
}
