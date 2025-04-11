package com.example.TanKhoaLearningCenterBE.entity;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name = "bills")
public class BillEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "billId")
    private UUID billId;

    @Column(name = "billStatus")
    private Boolean billStatus;
}
