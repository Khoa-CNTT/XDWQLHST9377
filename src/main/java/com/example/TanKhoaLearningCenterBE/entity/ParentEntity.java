package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
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

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    private List<StudentEntity> studentIds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private AccountEntity accountIds;
}
