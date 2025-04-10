package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Data
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paymentId")
    private UUID paymentId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payMId")
    private PaymentMethodEntity payMIds;

    @Column(name = "amount", nullable = false)
    @PositiveOrZero(message = "Amount cannot be negative")
    private Long amount;

    @Column(name = "transferTime")
    private Timestamp transferTime;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "billId")
    private BillEntity billIds;
}
