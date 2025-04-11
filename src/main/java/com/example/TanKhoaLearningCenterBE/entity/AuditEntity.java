package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;
import java.time.Instant;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class AuditEntity implements Serializable {
    @CreatedDate
    @Column(name = "createdAt", updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column(name = "updatedAt")
    private Instant updatedAt;
}
