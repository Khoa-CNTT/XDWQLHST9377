package com.example.TanKhoaLearningCenterBE.product.Services;

import com.example.TanKhoaLearningCenterBE.Command;
import com.example.TanKhoaLearningCenterBE.product.ProductRespository;
import com.example.TanKhoaLearningCenterBE.product.modal.Product;
import com.example.TanKhoaLearningCenterBE.product.modal.ProductDTO;
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
        List<Product> products = productRespository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }
}
