package com.example.TanKhoaLearningCenterBE.service.old;

import com.example.TanKhoaLearningCenterBE.dto.old.ProductDTO;
import com.example.TanKhoaLearningCenterBE.entity.old.ProductEntity;
import com.example.TanKhoaLearningCenterBE.exception.old.ProductNotFoundException;
import com.example.TanKhoaLearningCenterBE.repository.old.ProductRepository;
import com.example.TanKhoaLearningCenterBE.web.rest.old.reponse.PageResponse;
import com.example.TanKhoaLearningCenterBE.web.rest.old.request.CreateProductRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.old.request.UpdateProductRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDTO> create(CreateProductRequest request) {
        var prod = new ProductEntity();
        prod.setName(request.getName());
        prod.setDescription(request.getDescription());
        prod.setPrice(request.getPrice());
        var saveProduct = productRepository.save(prod);

        return ResponseEntity.status(HttpStatus.CREATED).body(new ProductDTO(saveProduct));
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDTO> put(Integer id, UpdateProductRequest command) {
        Optional<ProductEntity> productOptional = productRepository.findById(id);
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

            var res = productRepository.save(prod);

            return ResponseEntity.ok(new ProductDTO(res));
        }
        return null;
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<?> delete(Integer id) {
        Optional<ProductEntity> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            productRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new ProductNotFoundException();
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<PageResponse<ProductDTO>> getAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductEntity> products = productRepository.findAll(pageable);
        List<ProductDTO> rows = products.getContent().stream().map(ProductDTO::new).toList();
        var response = new PageResponse<ProductDTO>();
        response.setCount(products.getTotalElements()); // tong so phan tu
        response.setRows(rows); // data
        response.setPage(page);
        response.setSize(size);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<ProductDTO> get(Integer id){
        log.info("*** get id: {}", id );
        Optional<ProductEntity> productOptional = productRepository.findById(id);
        if (productOptional.isPresent()){
            productRepository.findById(id);
            return ResponseEntity.ok(new ProductDTO(productOptional.get()));
        }
        throw new ProductNotFoundException();
    }

    @Override
    @Cacheable("productCache")
    public ResponseEntity<List<ProductDTO>> search(String name){
        List<ProductEntity> productEntityOptional = productRepository.findByNameContaining(name);
        if (!productEntityOptional.isEmpty()) {
            productRepository.findByNameContaining(name);
            return ResponseEntity.ok(productRepository.findByNameContaining(name).stream().map(ProductDTO::new).toList());
        }
        throw new ProductNotFoundException();
    }
}
