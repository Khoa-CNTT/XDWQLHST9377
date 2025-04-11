package com.example.TanKhoaLearningCenterBE.repository;

import com.example.TanKhoaLearningCenterBE.entity.TeacherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TeacherEntityRepository extends JpaRepository<TeacherEntity, UUID> {
}