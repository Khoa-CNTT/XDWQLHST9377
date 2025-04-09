package com.example.TanKhoaLearningCenterBE.web.rest.old.request;

import lombok.Data;

@Data
public class UpdateProductRequest {
    private String name;
    private String description;
    private Double price;
}
