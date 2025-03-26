package com.example.TanKhoaLearningCenterBE.product.Services;

import com.example.TanKhoaLearningCenterBE.Command;
import com.example.TanKhoaLearningCenterBE.product.ProductRespository;
import com.example.TanKhoaLearningCenterBE.product.modal.Product;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteProductService implements Command<Integer, Void> {

    private ProductRespository productRespository;

    public DeleteProductService(ProductRespository productRespository) {
        this.productRespository = productRespository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer id) {
        Optional<Product> productOptional = productRespository.findById(id);
        if (productOptional.isPresent()){
            productRespository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return null;
//        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Product Deleted");
    }
}
