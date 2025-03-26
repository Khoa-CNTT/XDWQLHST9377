package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.entity.ProductEntity;
import com.example.TanKhoaLearningCenterBE.utils.Command;
import com.example.TanKhoaLearningCenterBE.repository.ProductRespository;
import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.request.UpdateProductRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutProductService implements Command<UpdateProductRequest, ProductDTO> {
    private final ProductRespository productRespository;

    public PutProductService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductRequest command) {
        Optional<ProductEntity> productOptional = productRespository.findById(command.getId());
        if (productOptional.isPresent()) {
            ProductEntity prod = productOptional.get();
            if (!command.getProduct().getName().isBlank()) {
                prod.setName(command.getProduct().getName());
            }

            if (!command.getProduct().getDescription().isBlank()) {
                prod.setDescription(command.getProduct().getDescription());
            }

            if (command.getProduct().getPrice() > 0) {
                prod.setPrice(command.getProduct().getPrice());
            }

            var res = productRespository.save(prod);

            return ResponseEntity.ok(new ProductDTO(res));
        }
        return null;
//        return ResponseEntity.status(HttpStatus.OK).body("Product Updated");
    }
}
