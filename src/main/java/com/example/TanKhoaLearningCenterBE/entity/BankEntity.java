package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "bank")
public class BankEntity {

    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", unique = true)
    private String name;

    @Column(name = "balance")
    @PositiveOrZero(message = "Price cannot be negative")
    private Double balance;
}
