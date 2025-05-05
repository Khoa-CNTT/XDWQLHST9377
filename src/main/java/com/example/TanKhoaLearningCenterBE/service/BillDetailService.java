package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.BillDetailDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.request.UpdateBillDetailsRequest;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public interface BillDetailService {
    ResponseEntity<BillDetailDTO> update(UUID id, UpdateBillDetailsRequest request);
}
