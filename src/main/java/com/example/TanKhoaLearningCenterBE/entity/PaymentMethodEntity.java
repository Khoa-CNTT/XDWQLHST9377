package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "paymentMethod")
public class PaymentMethodEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "payMId")
    private UUID payMId;

    @Column(name = "payMethod")
    private String payMethod;
}
