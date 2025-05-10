package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.BillDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateBillRequest;
import com.example.TanKhoaLearningCenterBE.web.rest.response.PageResponse;
import org.springframework.http.ResponseEntity;

public interface BillService {
    ResponseEntity<BillDTO> create(CreateBillRequest request);

    ResponseEntity<PageResponse<BillDTO>> getAll(Integer page, Integer size);
}
