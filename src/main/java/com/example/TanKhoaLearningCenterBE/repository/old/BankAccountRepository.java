package com.example.TanKhoaLearningCenterBE.repository.old;

import com.example.TanKhoaLearningCenterBE.entity.old.BankEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface BankAccountRepository extends JpaRepository<BankEntity, UUID> {
    Optional<BankEntity> findByName(String name);
}
