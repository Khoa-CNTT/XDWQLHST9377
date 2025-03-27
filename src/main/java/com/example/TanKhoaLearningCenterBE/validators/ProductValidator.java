package com.example.TanKhoaLearningCenterBE.validators;

import com.example.TanKhoaLearningCenterBE.entity.ProductEntity;
import com.example.TanKhoaLearningCenterBE.exception.ErrorMessages;
import com.example.TanKhoaLearningCenterBE.exception.ProductNotValidException;
import org.springframework.util.StringUtils;

public class ProductValidator {

    private ProductValidator(){

    }

    public static void execute(ProductEntity prod){
        if (StringUtils.isEmpty(prod.getName())){
            throw new ProductNotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }
        if (prod.getDescription().length() < 10){
            throw new ProductNotValidException(ErrorMessages.DESCRIPTION_LENGHT.getMessage());
        }
        if (prod.getPrice() == null || prod.getPrice() < 0.0){
            throw new ProductNotValidException(ErrorMessages.PRICE_CANNOT_BE_NEGATIVE.getMessage());
        }
    }
}
