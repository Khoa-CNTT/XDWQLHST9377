package com.example.TanKhoaLearningCenterBE.service.old;

import com.example.TanKhoaLearningCenterBE.web.rest.old.request.TransferRequest;
import org.springframework.http.ResponseEntity;

public interface TransferService{
    ResponseEntity<?> execute(TransferRequest transferRequest);
}
