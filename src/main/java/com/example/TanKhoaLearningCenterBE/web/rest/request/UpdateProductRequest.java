package com.example.TanKhoaLearningCenterBE.web.rest.request;

import com.example.TanKhoaLearningCenterBE.dto.ProductDTO;
import lombok.Data;
import lombok.Getter;

@Data
public class UpdateProductRequest {
    private String name;
    private String description;
    private Double price;
}
