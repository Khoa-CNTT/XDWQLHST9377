package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "roleId")
    private UUID roleId;

    @Column(name = "roleName", unique = true, nullable = false)
    private String roleName;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private List<UserRoleEntiy> roleIds;
}
