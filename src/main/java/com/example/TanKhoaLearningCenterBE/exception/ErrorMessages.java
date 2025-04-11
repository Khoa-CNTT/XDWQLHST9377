package com.example.TanKhoaLearningCenterBE.exception;

public enum ErrorMessages {
    ACCOUNT_NOT_FOUND("Account not found"),
    NAME_REQUIRED("Name is required"),
    DESCRIPTION_LENGHT("Description must be 10 characters"),
    PRICE_CANNOT_BE_NEGATIVE("Price cannot be negative");

    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
