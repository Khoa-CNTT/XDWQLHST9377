package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "parentId")
    private List<ParentEntity> parentIds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    @ToString.Exclude
    private AccountEntity accountId;
}