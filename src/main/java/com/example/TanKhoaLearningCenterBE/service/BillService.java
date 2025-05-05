package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.BillDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateBillRequest;
import org.springframework.http.ResponseEntity;

public interface BillService {
    ResponseEntity<BillDTO> create(CreateBillRequest request);
}
