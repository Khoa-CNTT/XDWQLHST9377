package com.example.TanKhoaLearningCenterBE.repository;

import com.example.TanKhoaLearningCenterBE.entity.ParentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ParentEntityRepository extends JpaRepository<ParentEntity, UUID>{
}