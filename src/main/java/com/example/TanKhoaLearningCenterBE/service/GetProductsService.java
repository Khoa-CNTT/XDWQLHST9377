package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.entity.ProductEntity;
import com.example.TanKhoaLearningCenterBE.utils.Command;
import com.example.TanKhoaLearningCenterBE.repository.ProductRespository;
import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetProductsService implements Command<Void, List<ProductDTO>> {

    private final ProductRespository productRespository;

    public GetProductsService(ProductRespository productRespository){
        this.productRespository = productRespository;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> execute(Void input) {
        List<ProductEntity> products = productRespository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }
}
