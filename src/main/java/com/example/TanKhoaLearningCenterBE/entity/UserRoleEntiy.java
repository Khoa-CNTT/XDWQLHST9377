package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.UUID;

@Entity
@Data
@Table(name = "userRoles")
public class UserRoleEntiy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userRoleId")
    private UUID userRoleId;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private List<RoleEntity> roleIds;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private AccountEntity accountIds;
}
