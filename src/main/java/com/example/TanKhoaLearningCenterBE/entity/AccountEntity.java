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

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "create_at", nullable = false)
    private Timestamp createAt;

    @Column(name = "modify_at")
    private Timestamp modifyAt;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "userRoles_roleId1")
//    private UserRoleEntiy userRoleId;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "students_studentId")
//    private StudentEntity student;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "parents_parentId")
//    private ParentEntity parent;
//
//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "teachers_teacherId")
//    private TeacherEntity teacher;
}
