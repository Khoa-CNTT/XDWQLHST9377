package com.example.TanKhoaLearningCenterBE.product;

import com.example.TanKhoaLearningCenterBE.product.modal.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRespository extends JpaRepository<Product, Integer> {
}
