package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateProductRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.request.UpdateProductRequest;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<ProductDTO> create(CreateProductRequest request);
    ResponseEntity<ProductDTO> put(Integer id, UpdateProductRequest request);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<ProductDTO> get(Integer id);
    ResponseEntity<List<ProductDTO>> getAll();
    ResponseEntity<List<ProductDTO>> search(String input);
}
