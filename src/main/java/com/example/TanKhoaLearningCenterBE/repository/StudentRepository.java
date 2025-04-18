package com.example.TanKhoaLearningCenterBE.repository;

import com.example.TanKhoaLearningCenterBE.entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentEntity, UUID> {
//    Optional<StudentEntity> findByStdName(String stdName);

    List<StudentEntity> findByStdNameContaining(String name);
}
