package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.userdetails.User;

import java.util.UUID;

@Entity
@Data
@Table(name = "user_profiles")
public class UserProfileEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private UUID id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "accountId")
    private UserEntity accountId;

    @Column(name = "avatar")
    private byte avatar;

    @Column(name = "gender")
    private boolean gender;
}
