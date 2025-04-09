package com.example.TanKhoaLearningCenterBE.web.rest.old.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private Double price;
}
