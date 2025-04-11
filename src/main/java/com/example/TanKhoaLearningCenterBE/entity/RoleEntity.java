package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "roles")
public class RoleEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "roleId")
    private UUID roleId;

    @Column(name = "roleName", unique = true, nullable = false)
    private String roleName;
}
