package com.example.TanKhoaLearningCenterBE.product.Services;

import com.example.TanKhoaLearningCenterBE.Query;
import com.example.TanKhoaLearningCenterBE.product.ProductRespository;
import com.example.TanKhoaLearningCenterBE.product.modal.Product;
import com.example.TanKhoaLearningCenterBE.product.modal.ProductDTO;
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
        Optional<Product> productOptional = productRespository.findById(input);
        if (productOptional.isPresent()){
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }

        //In the future we will want to throw exeptional if we can find id

        return null;
    }
}
