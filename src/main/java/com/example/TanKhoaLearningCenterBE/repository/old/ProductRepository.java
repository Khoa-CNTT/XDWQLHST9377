package com.example.TanKhoaLearningCenterBE.repository.old;

import com.example.TanKhoaLearningCenterBE.entity.old.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Integer> {
    List<ProductEntity> findByNameContaining(String name);
}
