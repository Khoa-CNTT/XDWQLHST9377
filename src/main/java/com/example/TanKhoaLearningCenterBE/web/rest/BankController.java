package com.example.TanKhoaLearningCenterBE.web.rest;

import com.example.TanKhoaLearningCenterBE.service.TransferService;
import com.example.TanKhoaLearningCenterBE.web.rest.request.TransferRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class BankController {

    private final TransferService transferService;

    public BankController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("")
    public ResponseEntity<?> transfer(@RequestBody TransferRequest transferDTO){
        return transferService.execute(transferDTO);
    }
}
