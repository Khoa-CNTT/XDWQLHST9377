package com.example.TanKhoaLearningCenterBE.web.rest.request;

import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import lombok.Getter;

@Getter
public class UpdateProductRequest {
    private final Integer id;
    private final ProductDTO product;

    public UpdateProductRequest(Integer id, ProductDTO product) {
        this.id = id;
        this.product = product;
    }
}
