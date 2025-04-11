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
public class AccountEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "accountId")
    private UUID accountId;

    @NotNull(message = "Username is required")
    @Column(name = "username")
    private String userName;

    @Column(name = "password", nullable = false)
    private String passWord;


}
