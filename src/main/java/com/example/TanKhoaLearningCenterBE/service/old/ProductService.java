package com.example.TanKhoaLearningCenterBE.service.old;

import com.example.TanKhoaLearningCenterBE.dto.old.ProductDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.old.reponse.PageResponse;
import com.example.TanKhoaLearningCenterBE.web.rest.old.request.CreateProductRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.old.request.UpdateProductRequest;
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
