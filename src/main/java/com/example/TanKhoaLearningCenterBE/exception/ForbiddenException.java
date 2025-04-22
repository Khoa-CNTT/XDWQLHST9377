package com.example.TanKhoaLearningCenterBE.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class ForbiddenException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ForbiddenException.class);

    public ForbiddenException(){
        super(ErrorMessages.FORBIDDEN.getMessage());
        logger.error("***Exception {} thrown.", getClass());
    }
}
