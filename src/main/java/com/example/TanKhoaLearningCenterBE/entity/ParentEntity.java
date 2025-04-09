package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "parents")
public class ParentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "parentId")
    private UUID parentId;

    @Column(name = "parName", nullable = false)
    private String parentName;

    @Column(name = "parPhoneNumber", nullable = false, unique = true)
    private String parPhoneNumber;

    @Column(name = "parEmail")
    private String parEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private AccountEntity accountId;
}
