package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.reponse.PageResponse;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateProductRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.request.UpdateProductRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProductService {
    ResponseEntity<ProductDTO> create(CreateProductRequest request);
    ResponseEntity<ProductDTO> put(Integer id, UpdateProductRequest request);
    ResponseEntity<?> delete(Integer id);
    ResponseEntity<ProductDTO> get(Integer id);
    ResponseEntity<PageResponse<ProductDTO>> getAll(Integer page, Integer size);
    ResponseEntity<List<ProductDTO>> search(String input);
}
