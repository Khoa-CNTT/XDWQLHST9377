package com.example.TanKhoaLearningCenterBE.product.Services;

import com.example.TanKhoaLearningCenterBE.Command;
import com.example.TanKhoaLearningCenterBE.product.ProductRespository;
import com.example.TanKhoaLearningCenterBE.product.modal.Product;
import com.example.TanKhoaLearningCenterBE.product.modal.ProductDTO;
import com.example.TanKhoaLearningCenterBE.product.modal.UpdateProductCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PutProductService implements Command<UpdateProductCommand, ProductDTO> {
    private ProductRespository productRespository;

    public PutProductService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateProductCommand command) {
        Optional<Product> productOptional = productRespository.findById(command.getId());
        if (productOptional.isPresent()) {
            Product product = command.getProduct();
            product.setId(command.getId());
            productRespository.save(product);
            return ResponseEntity.ok(new ProductDTO(product));
        }
        return null;
//        return ResponseEntity.status(HttpStatus.OK).body("Product Updated");
    }
}
