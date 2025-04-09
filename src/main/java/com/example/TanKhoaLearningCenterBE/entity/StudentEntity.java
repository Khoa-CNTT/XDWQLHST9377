package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "students")
public class StudentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private UUID studentId;

    @Column(name = "stdName", nullable = false)
    private String stdName;

    @Column(name = "stdPhoneNumber", nullable = false, unique = true)
    private String stdPhoneNumber;

    @Column(name = "stdEmail", unique = true)
    private String stdEmail;

    @Column(name = "parentId", nullable = false)
    private UUID parentId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private AccountEntity accountId;
}
