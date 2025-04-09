package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
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

    @Column(name = "username", unique = true, nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @Column(name = "modify_at")
    private Timestamp modifyAt;

    @OneToOne(mappedBy = "accountId",cascade = CascadeType.ALL)
    private UserRoleEntiy accountIds;

    @OneToOne(mappedBy = "accountId")
    private StudentEntity student;

    @OneToOne(mappedBy = "accountId")
    private ParentEntity parent;

    @OneToOne(mappedBy = "accountId")
    private TeacherEntity teacher;
}
