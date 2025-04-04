package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.entity.BankEntity;
import com.example.TanKhoaLearningCenterBE.web.rest.request.TransferRequest;
import org.springframework.http.ResponseEntity;

public interface TransferService{
    ResponseEntity<?> deduct(BankEntity bankEntity, double amount);
    ResponseEntity<?> add(BankEntity bankEntity, double amount);
    ResponseEntity<?> execute(TransferRequest transferRequest);
}
