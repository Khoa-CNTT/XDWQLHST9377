package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import com.example.TanKhoaLearningCenterBE.entity.ProductEntity;
import com.example.TanKhoaLearningCenterBE.repository.ProductRespository;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateProductRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRespository productRespository;

    @Override
    public ResponseEntity<ProductDTO> create(CreateProductRequest request) {
        var prod = new ProductEntity();
        prod.setName(request.getName());
        prod.setDescription(request.getDescription());
        prod.setPrice(request.getPrice());
        var saveProduct = productRespository.save(prod);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(saveProduct));
    }

    @Override
    public ResponseEntity<ProductDTO> put(Integer id, UpdateProductRequest command) {
        Optional<ProductEntity> productOptional = productRespository.findById(id);
        if (productOptional.isPresent()) {
            ProductEntity prod = productOptional.get();
            if (!command.getName().isBlank()) {
                prod.setName(command.getName());
            }

            if (!command.getDescription().isBlank()) {
                prod.setDescription(command.getDescription());
            }

            if (command.getPrice() > 0) {
                prod.setPrice(command.getPrice());
            }

            var res = productRespository.save(prod);

            return ResponseEntity.ok(new ProductDTO(res));
        }
        return null;
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        Optional<ProductEntity> productOptional = productRespository.findById(id);
        if (productOptional.isPresent()){
            productRespository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return null;
    }

    @Override
    public ResponseEntity<List<ProductDTO>> getAll() {
        List<ProductEntity> products = productRespository.findAll();
        List<ProductDTO> productDTOs = products.stream().map(ProductDTO::new).toList();

        return ResponseEntity.status(HttpStatus.OK).body(productDTOs);
    }

    @Override
    public ResponseEntity<ProductDTO> get(Integer id) {
        Optional<ProductEntity> productOptional = productRespository.findById(id);
        return productOptional.map(productEntity -> ResponseEntity.ok(new ProductDTO(productEntity))).orElse(null);
    }
}
