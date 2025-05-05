package com.example.TanKhoaLearningCenterBE.web.rest;

import com.example.TanKhoaLearningCenterBE.dto.BillDTO;
import com.example.TanKhoaLearningCenterBE.service.BillService;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateBillRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bill")
@RequiredArgsConstructor
public class BillController {
    private final BillService billService;

    @PostMapping("/create")
    public ResponseEntity<BillDTO> createBill(@RequestBody CreateBillRequest request) {
        return billService.create(request);
    }
}
