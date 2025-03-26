package com.example.TanKhoaLearningCenterBE.product;

import com.example.TanKhoaLearningCenterBE.product.Services.*;
import com.example.TanKhoaLearningCenterBE.product.modal.Product;
import com.example.TanKhoaLearningCenterBE.product.modal.ProductDTO;
import com.example.TanKhoaLearningCenterBE.product.modal.UpdateProductCommand;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    private final CreateProductService createProductService;

    private final GetProductsService getProductsService;

    private final PutProductService putProductService;

    private final DeleteProductService deleteProductService;

    private final GetProductService getProductService;

    public ProductController(CreateProductService createProductService,
                             GetProductsService getProductsService,
                             PutProductService putProductService,
                             DeleteProductService deleteProductService,
                             GetProductService getProductService) {
        this.createProductService = createProductService;
        this.getProductsService = getProductsService;
        this.putProductService = putProductService;
        this.deleteProductService = deleteProductService;
        this.getProductService = getProductService;
    }

    @PostMapping("/product")
    public ResponseEntity<ProductDTO> createProduct(@RequestBody Product product) {
        return createProductService.execute(product);
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>>  getProducts(){
        return getProductsService.execute(null);
    }

    //new get mapping for find Id
    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Integer id){
        return getProductService.execute(id);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductDTO>  updateProduct(@PathVariable Integer id, @RequestBody Product product){
        return putProductService.execute(new UpdateProductCommand(id, product));
    }

    @DeleteMapping("/product/{id}")
    public ResponseEntity<Void>  deleteProduct(@PathVariable Integer id){
        return deleteProductService.execute(id);
    }
}
