package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.entity.ProductEntity;
import com.example.TanKhoaLearningCenterBE.utils.Query;
import com.example.TanKhoaLearningCenterBE.repository.ProductRespository;
import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GetProductService implements Query<Integer, ProductDTO> {
    private final ProductRespository productRespository;

    public GetProductService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Integer input) {
        Optional<ProductEntity> productOptional = productRespository.findById(input);
        return productOptional.map(productEntity -> ResponseEntity.ok(new ProductDTO(productEntity))).orElse(null);

        //In the future we will want to throw exeptional if we can find id

    }
}
