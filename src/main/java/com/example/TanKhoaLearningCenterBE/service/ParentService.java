package com.example.TanKhoaLearningCenterBE.service;

import com.example.TanKhoaLearningCenterBE.dto.ParentDTO;
import com.example.TanKhoaLearningCenterBE.web.rest.request.CreateParentRequest;
import org.springframework.http.ResponseEntity;

public interface ParentService {
    ResponseEntity<ParentDTO> create(CreateParentRequest request);
}
