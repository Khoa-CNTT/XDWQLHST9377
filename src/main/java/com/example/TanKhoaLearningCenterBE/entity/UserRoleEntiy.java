package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "userRoles")
public class UserRoleEntiy extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "userRoleId")
    private UUID userRoleId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private RoleEntity roleIds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private AccountEntity accountIds;
}
