package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "Username is required")
    @Column(name = "username")
    private String userName;

    @Column(name = "password", nullable = false)
    private String passWord;

    @Column(name = "createAt", nullable = false)
    private Timestamp createAt;

    @Column(name = "modifiedAt")
    private Timestamp modifiedAt;
}
