package com.example.TanKhoaLearningCenterBE.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name="product")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotNull(message = "Name is required")
    @Column(name="name")
    private String name;

    @Size(min = 10, message = "Description must be 10 characters")
    @Column(name="description")
    private String description;

    @PositiveOrZero(message = "Price cannot be negative")
    @Column(name="price")
    private Double price;
}
