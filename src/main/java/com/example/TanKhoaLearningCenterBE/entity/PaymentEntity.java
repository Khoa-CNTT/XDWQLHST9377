package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private UUID paymentId;

    @Column(name = "paymentMethod")
    private String payMethod;

    @Column(name = "amount")
    @PositiveOrZero(message = "Amount cannot be negative")
    private Long amount;

    @Column(name = "transferTime")
    private Timestamp transferTime;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "billId")
    private List<BillEntity> billId;
}
