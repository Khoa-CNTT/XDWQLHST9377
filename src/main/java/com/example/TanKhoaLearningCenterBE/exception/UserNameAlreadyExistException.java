package com.example.TanKhoaLearningCenterBE.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserNameAlreadyExistException extends RuntimeException{
    private static final Logger logger = LoggerFactory.getLogger(UserNameAlreadyExistException.class);

    public UserNameAlreadyExistException(String username){
        super(ErrorMessages.USERNAME_ALREADY_EXIST.getMessage());
        logger.error("***Exception {} thrown.", getClass());
    }
}
