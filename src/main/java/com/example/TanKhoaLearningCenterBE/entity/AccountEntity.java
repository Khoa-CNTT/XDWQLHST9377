package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @NotNull(message = "Password is required")
    @Column(name = "password")
    private String passWord;
}
