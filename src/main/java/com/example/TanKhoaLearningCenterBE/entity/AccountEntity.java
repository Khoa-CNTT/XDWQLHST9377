package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accountId")
    private UUID accountId;

    @Column(name = "username", nullable = false, unique = true)
    private String userName;

    @Column(name = "password", nullable = false)
    private String passWord;

    @Column(name = "createAt", nullable = false)
    private Timestamp createAt;

    @Column(name = "modifiedAt")
    private Timestamp modifiedAt;
}
