package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "userRoles")
public class UserRoleEntiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userRoleId")
    private UUID userRoleId;

    @Column(name = "roleId1")
    private UUID roleId;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id")
    private AccountEntity accountIds;
}
