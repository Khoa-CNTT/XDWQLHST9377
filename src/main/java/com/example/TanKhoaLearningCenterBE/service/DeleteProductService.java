package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.entity.ProductEntity;
import com.example.TanKhoaLearningCenterBE.utils.Command;
import com.example.TanKhoaLearningCenterBE.repository.ProductRespository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {

    private final ProductRespository productRespository;

    public DeleteProductService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<ProductEntity> productOptional = productRespository.findById(id);
        if (productOptional.isPresent()){
            productRespository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return null;
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product Deleted");
    }
}
