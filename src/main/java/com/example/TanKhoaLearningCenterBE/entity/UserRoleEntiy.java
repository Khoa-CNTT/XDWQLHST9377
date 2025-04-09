package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "userRoles")
public class UserRoleEntiy {

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "roleId")
    private RoleEntity roleId;

    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private AccountEntity accountId;
}
