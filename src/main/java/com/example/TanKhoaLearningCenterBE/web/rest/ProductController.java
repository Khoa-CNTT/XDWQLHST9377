package com.example.TanKhoaLearningCenterBE.web.rest;

import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import com.example.TanKhoaLearningCenterBE.service.*;
import com.example.TanKhoaLearningCenterBE.web.rest.reponse.PageResponse;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateProductRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductRequest product) {
        return productService.create(product);
    }

    @GetMapping("/products")
    public ResponseEntity<PageResponse<ProductDTO>> getProducts(@RequestParam(value = "page", required = false, defaultValue = "0") Integer page,
                                                                @RequestParam(value = "size", required = false, defaultValue = "10") Integer size){
        return productService.getAll(page, size);
    }

    //new get mapping for find Id
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return productService.get(id);
    }

    @GetMapping("/product/search")
    public ResponseEntity<List<ProductDTO>> searchProductsByName(@RequestParam String name){
        return productService.search(name);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO>  updateProduct(@PathVariable Integer id, @RequestBody UpdateProductRequest product){
        return productService.put(id, product);
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<?>  deleteProduct(@PathVariable Integer id){
        return productService.delete(id);
    }
}
