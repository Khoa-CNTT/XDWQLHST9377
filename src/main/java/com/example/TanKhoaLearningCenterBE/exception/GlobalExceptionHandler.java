package com.example.TanKhoaLearningCenterBE.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {
    //Add more exeption handler
    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorReponse handleProductNotFoundException(ProductNotFoundException exception){
        return new ErrorReponse(exception.getMessage());
    }

    @ExceptionHandler(ProductNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorReponse handleProductNotValidExeption(ProductNotValidException exception){
        return new ErrorReponse(exception.getMessage());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorReponse handleProductNotValidConstraints(ConstraintViolationException exception){
        return new ErrorReponse(exception.getConstraintViolations().iterator().next().getMessage());
    }
}
