package com.example.TanKhoaLearningCenterBE.exception;

public enum ErrorMessages {
    ACCOUNT_NOT_FOUND("Account not found"),
    USERNAME_ALREADY_EXIST("Username already exist, pick another one"),
    ROLENAME_ALREADY_EXIST("Rolename already exist");

    private final String message;

    ErrorMessages(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }
}
