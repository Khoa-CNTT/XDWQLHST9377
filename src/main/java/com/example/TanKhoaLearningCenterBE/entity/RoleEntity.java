package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "roles")
public class RoleEntity extends AuditEntity {
    @Id
    @GeneratedValue
    @Column(name = "roleId")
    private UUID roleId;

    @Column(name = "roleName", unique = true, nullable = false)
    private String roleName;
}
