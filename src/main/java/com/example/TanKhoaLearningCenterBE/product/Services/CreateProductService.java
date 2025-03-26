package com.example.TanKhoaLearningCenterBE.product.Services;

import com.example.TanKhoaLearningCenterBE.Command;
import com.example.TanKhoaLearningCenterBE.product.ProductRespository;
import com.example.TanKhoaLearningCenterBE.product.modal.Product;
import com.example.TanKhoaLearningCenterBE.product.modal.ProductDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateProductService implements Command<Product, ProductDTO> {

    private final ProductRespository productRespository;

    public CreateProductService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Product product) {
        Product saveProduct = productRespository.save(product);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(saveProduct));
    }
}
