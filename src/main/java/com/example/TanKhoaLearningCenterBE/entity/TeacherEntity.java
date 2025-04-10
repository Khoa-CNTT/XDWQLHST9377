package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.UUID;

@Entity
@Data
@Table(name = "teachers")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacherId")
    private UUID teacherId;

    @Column(name = "teacherName", nullable = false)
    private String teacherName;

    @Column(name = "tphoneNumber", nullable = false, unique = true)
    private String tphoneNumber;

    @Column(name = "tEmail", nullable = false, unique = true)
    private String tEmail;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    @ToString.Exclude
    private AccountEntity accountId;
}
