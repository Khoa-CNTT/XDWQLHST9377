package com.example.TanKhoaLearningCenterBE.exception;

import lombok.Getter;

@Getter
public class ErrorReponse {
    private String message;

    public ErrorReponse(String message) {
        this.message = message;
    }
}
