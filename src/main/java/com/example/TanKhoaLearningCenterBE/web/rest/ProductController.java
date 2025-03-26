package com.example.TanKhoaLearningCenterBE.web.rest;

import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import com.example.TanKhoaLearningCenterBE.service.*;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateProductRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;
//    private final CreateProductService createProductService;

//    private final GetProductsService getProductsService;
//
//    private final PutProductService putProductService;
//
//    private final DeleteProductService deleteProductService;
//
//    private final GetProductService getProductService;

//    public ProductController(CreateProductService createProductService,
//                             GetProductsService getProductsService,
//                             PutProductService putProductService,
//                             DeleteProductService deleteProductService,
//                             GetProductService getProductService) {
//        this.createProductService = createProductService;
//        this.getProductsService = getProductsService;
//        this.putProductService = putProductService;
//        this.deleteProductService = deleteProductService;
//        this.getProductService = getProductService;
//    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductRequest product) {
        return productService.create(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>>  getProducts(){
        return productService.getAll();
    }

    //new get mapping for find Id
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return productService.get(id);
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
