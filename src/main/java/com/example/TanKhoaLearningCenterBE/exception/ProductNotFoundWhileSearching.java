package com.example.TanKhoaLearningCenterBE.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ProductNotFoundWhileSearching extends RuntimeException{
    public ProductNotFoundWhileSearching() {
        super(ErrorMessages.PRODUCT_NOT_FOUND.getMessage());
    }
}
