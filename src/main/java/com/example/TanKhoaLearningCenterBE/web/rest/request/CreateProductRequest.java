package com.example.TanKhoaLearningCenterBE.web.rest.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private Double price;
}
